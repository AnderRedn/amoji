$(function() {
	$('.btnAdd').tooltip({title: "Añadir nuevo", trigger: "hover"});
	$('.btnDltType').tooltip({title: "Eliminar Tipo", trigger: "hover"});
	$('.btnModify').tooltip({title: "Modificar", trigger: "hover"});
	$('.btnDelete').tooltip({title: "Borrar", trigger: "hover"});
	$('.btnUndo').tooltip({title: "Resetear", trigger: "hover"});
	$("[data-toggle='tooltip']").tooltip({title: "Copiado!", trigger: "click"})
	$("[data-toggle='tooltip']").click(function(){
	    var button = $(this)
	    button.tooltip("show");
	    setTimeout(function(){
	    	button.tooltip("hide");
	    }, 2000);
	    var copyText = $("span#"+button[0].id) 
	    var textArea = document.createElement("textarea");
	    textArea.value = copyText[0].innerHTML.replace( /&lt;/g, "<" ).replace( /&gt;/g, ">" ).replace( /&quot;/g, "\"" ).replace( /&amp;/g, "&" );
	    document.body.appendChild(textArea);
	    textArea.select();
	    document.execCommand("copy");
	    textArea.remove();
	});
})