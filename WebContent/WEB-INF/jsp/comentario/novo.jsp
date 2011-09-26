
<%@ include file="../../../header.jsp" %>

<div id="comentarioWrap" style="margin-left: auto; margin-right: auto;">

	<form id="novoComentario" action="<c:url value="/comentario" />" enctype="multipart/form-data" method="post">
		
		<fieldset id="comentarioAreaCampo" style="width: 770px; height: 300px;"><br>
	
		<legend>Comentar sobre o tópico: ${topicoAtual.assunto}</legend>
		
		<ul id="comentarioElementsEn">
			
			<li>
				<input type="hidden" id="topico" name="comentario.topico.id" value="${topicoAtual.id}"/>
				<label>E-Mail</label>
				<input type="text" id="email" class="required" email="1" name="comentario.email" value="${comentario.email}" onfocus="this.value='';" 
	       			onblur="if (this.value == '') this.value='${comentario.email}/>'"/><br/><br/>
	       	 	<label>Comentário</label>
	       	 	<textarea id="texto" name="comentario.texto" class="required" maxlength="256" onfocus="this.value='';" 
	       			onblur="if (this.value == '') this.value='${comentario.texto}>'"/></textarea><br/><br/>
	       	 	
   				<button type="submit" value="registrar">Regitrar</button>
   				<input type="button" style="width: 9em;" value="Criar Novo Tópico" onclick="window.location.href='${path }'">
	       	</li>
	    </ul>
	
		</fieldset><br/><br/>
		
	</form>
	
	<script type="text/javascript">
		$('#novoComentario').validate();
	</script>

</div>
<div>
	<table>
		<thead>
			<tr>
				<td align="center">E-Mail</td>
				<td align="center">Comentário</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="comentario" items="${comentarioList}" varStatus="s">
				<tr class="${s.count % 2 == 0? 'even': 'odd' }">
					<td>${comentario.email}</td>
					<td>${comentario.texto}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@ include file="../../../footer.jsp" %>		
