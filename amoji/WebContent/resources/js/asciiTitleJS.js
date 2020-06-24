$(function() {
	
	$("#idPre").tooltip({title: "Copiado!", trigger: "click"})
	$("#idPre").click(function(){
	    var button = $(this)
	    button.tooltip("show");
	    setTimeout(function(){
	    	button.tooltip("hide");
	    }, 2000);
	    var copyText = $("pre#idPre") 
	    var textArea = document.createElement("textarea");
	    textArea.value = copyText[0].innerHTML;
	    document.body.appendChild(textArea);
	    textArea.select();
	    document.execCommand("copy");
	    textArea.remove();
	});
	
});