<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <body>
        <form:form method="GET" modelAttribute="bookSearchCriteria">
            <fieldset>
                <legend>Search criteria</legend>
                <table>
                    <tr>
                        <td><form:label path="title">Title</form:label></td>
                        <td><form:input path="title"/></td>
                    </tr>
                </table>
            </fieldset>
            <button id="search">Search</button>
        </form:form>
    </body>
</html>
