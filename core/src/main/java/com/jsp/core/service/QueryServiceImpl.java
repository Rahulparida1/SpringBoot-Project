package com.jsp.core.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jsp.core.dto.ReadRequestDto;
import com.jsp.core.entity.Clauses;
import com.jsp.core.entity.Predicates;
import com.jsp.core.entity.Projection;
@Service
public class QueryServiceImpl implements QueryService{

	@Override
	public String generateSQLQuery(ReadRequestDto readRequest) {
		
		StringBuilder sqlQuery = new StringBuilder(" SELECT ");

        // Construct SELECT clause
        List<String> projectionFields = readRequest.getProjections().stream()
                .map(Projection::getFieldName)
                .collect(Collectors.toList());

        if (projectionFields.isEmpty()) {
            sqlQuery.append("*");
        } else {
            sqlQuery.append(String.join(", ", projectionFields));
        }

        // Construct FROM clause
        sqlQuery.append(" FROM ").append(readRequest.getEntityName());

        // Construct WHERE clause
        if (readRequest.getFilter() != null && readRequest.getFilter().getClauses() != null) {
            String whereClause = readRequest.getFilter().getClauses().stream()
                    .map(this::buildFilterClause)
                    .collect(Collectors.joining	(" AND "));

            sqlQuery.append(" WHERE ").append(whereClause);
        }

        // You can handle ORDER BY logic here if needed
        // sqlQuery.append(" ORDER BY ...");

        return sqlQuery.toString();
    }

    private String buildFilterClause(Clauses clauses) {
        String predicateString = clauses.getPredicates().stream()
                .map(this::buildPredicate)
                .collect(Collectors.joining(" " + clauses.getType() + " "));

        return "(" + predicateString + ")";
    }

    private String buildPredicate(Predicates predicates) {
        String dimension = predicates.getDimension();
        String operator = predicates.getOperator();
        String value = predicates.getValue();

        if ("BETWEEN".equals(operator)) {
            Object object1 = predicates.getRange().get(0);
            Object object2 = predicates.getRange().get(1);

           return dimension + " BETWEEN " + object1 + " AND " + object2;
       } else {
           return dimension + " " + operator + " " + value + "";
       }
   }	
 }