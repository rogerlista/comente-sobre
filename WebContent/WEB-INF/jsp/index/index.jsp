<%@ include file="../../../header.jsp" %> 

<div id="topicoWrap" style="margin-left: auto; margin-right: auto;">

	<form id="novoTopico" action="<c:url value="/topico"/>" enctype="multipart/form-data" name="topicoRegister" method="post">
		
		<fieldset style="width: 770px; height: 110px;"><br>
	
		<legend>Novo Tópico</legend>
		
		<ul id="topicoElementsEn">
			
			<li><input type="text" id="assunto" class="required" minlength="3" name="topico.assunto" value="${topico.assunto}"	onfocus="this.value='';" 
	       			onblur="if (this.value == '') this.value='${topico.assunto}/>'"/>
	       	 
	       		<button type="submit" value="salvar">Criar</button>
	       	</li>
	    </ul>
	
		</fieldset><br/><br/>
		
	</form>
	
	<script type="text/javascript">
		$('#novoTopico').validate();
	</script>

</div>

<div>
	<table>
		<thead>
			<tr>
				<td align="center">Tópicos</td>
				<td align="center">Comentários</td>
				<td align="center">Comentar</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="topico" items="${topicoList}" varStatus="s">
				<tr class="${s.count % 2 == 0? 'even': 'odd' }">
					<td>${topico.assunto}</td>
					<td align="center">${topico.totalDeComentarios}</td>
					<td align="center"><input type="button" style="width: 6em; text-align: center; font-size: 12pt;" value="Comentar" onclick="window.location.href='${path}topico/${topico.id}'">
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@ include file="../../../footer.jsp" %> 
