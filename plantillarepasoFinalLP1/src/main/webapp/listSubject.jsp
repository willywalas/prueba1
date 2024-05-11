<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="entidades.Subject" %>
<%@ page import="entidades.Student" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.datatables.net/2.0.5/css/dataTables.dataTables.min.css" />
</head>
<body>
	<div
		class="container min-vh-100 d-flex justify-content-center align-items-center">
		<div class="row">
			<div class="col-12">
				<form action="SubjectServlet">
					<input type="hidden" name="type" value="register">
					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">Alumno</label>
						<% List<Student> listStudent = (List<Student>) session.getAttribute("listStudent"); %>
						
						
						<select class="form-control" name="cboAlumno">
							<%
						if(listStudent != null){
							for (Student item: listStudent){ %>
								<option value="<%=item.getIdStudent()%>">
								<%=item.getName() + item.getLastname()%>
								</option>
							<% }
						}
						%>
						</select>

					</div>
					<div class="mb-3">
						<label for="exampleInputPassword1" class="form-label">Curso</label>
						<% List<Subject> listSubject = (List<Subject>) session.getAttribute("listSubject"); %>
						<select class="form-control" name="cboCurso">
							<%
						if(listSubject != null){
							for (Subject item: listSubject){ %>
								<option value="<%=item.getId()%>">
								<%=item.getName()%>
								</option>
							<% }
						}
						%>
						</select>
					</div>
					<button type="submit" class="btn btn-primary">Registrar</button>
				</form>
			</div>

			<div class="col-12">
				<table class="table">
					<thead>
						<tr>
							<th>Nombre del curso</th>
							<th>Cantidad de vacantes</th>
						</tr>
					</thead>
					<tbody>
						<%
						if (listSubject != null){
							for (Subject item:listSubject){ %>
							<tr>
								<td><%=item.getName() %></td>
								<td><%=item.getAvailable() %></td>
							</tr>
								
							<%}
						}
						%>

					</tbody>
				</table>
			</div>}
			<%
				String mensaje = (String) request.getAttribute("mensaje");
			if(mensaje!=null){ %>
							<div class="alert alert-danger">
								<strong>Error!</strong><%=mensaje %>
							</div>
			<%}
			%>

		</div>
	</div>

	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
		
	</script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/2.0.5/js/dataTables.min.js">
		
	</script>
</body>
</html>