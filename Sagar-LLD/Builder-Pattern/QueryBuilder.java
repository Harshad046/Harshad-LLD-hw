import java.util.Optional;

public class QueryBuilder {
    private String select;
    private String from;
    private String where;
    private String groupBy;
    private String having;
    private String orderBy;

    public static QueryBuilder builder() {
        return new QueryBuilder();
    }

    public QueryBuilder select(String select) {
        this.select = select;
        return this;
    }

    public QueryBuilder from(String from) {
        this.from = from;
        return this;
    }

    public QueryBuilder where(String where) {
        this.where = where;
        return this;
    }

    public QueryBuilder groupBy(String groupBy) {
        this.groupBy = groupBy;
        return this;
    }

    public QueryBuilder having(String having) {
        this.having = having;
        return this;
    }

    public QueryBuilder orderBy(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public String build() {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT ")
                .append(Optional.ofNullable(this.select)
                        .orElseThrow(() -> new RuntimeException("Select is mandatory field")))
                .append(" FROM ")
                .append(Optional.ofNullable(this.from)
                        .orElseThrow(() -> new RuntimeException("From is mandatory field")))
                .append(this.where != null ? " WHERE " + this.where : "")
                .append(this.groupBy != null ? " GROUP BY " + this.groupBy : "")
                .append(this.having != null ? " HAVING " + this.having : "")
                .append(this.orderBy != null ? " ORDER BY " + this.orderBy : "");
        return builder.toString();
    }
}
