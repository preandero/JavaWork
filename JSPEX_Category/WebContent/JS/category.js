

$(document).ready(function(){
	
	
	var txt = "";
	var txt2 = "";
	var txt3 = "";
	
	$.ajax({
		
		url : "cate_list.ajax",
		type : "POST",
		cache : false,
//		data : { 
//			"depth" : 1
//		},
		success : function(data, status){
			
			if(status  =="success"){
				if(data.status == "OK"){
					var count = data.data.length;
					txt += "<option>분류1</option>\n";
					for(i = 0; i < count; i++){
						
						if(data.data[i].depth == 1){
						
					txt += "<option value='"+ data.data[i].uid +"'>"+ data.data[i].name + "</option>\n";
						}
				}
					
					$("#select").append(txt);
					$("#select").removeAttr("disabled") 
					
					$("#select").change(function(){
						txt2 += "<option>분류2</option>\n"
						for(i = 0; i < count; i++){
						if($(this).val() == data.data[i].parent){
							txt2 += "<option value='"+ data.data[i].uid +"'>"+ data.data[i].name + "</option>\n";
						}
					}
						
						
						
						$("#select2").html("");
						$("#select3").html("");
						$("#select3").attr("disabled", true);
						$("#select2").html(txt2);
						$("#select2").removeAttr("disabled") 
						
						txt2 = "";
					})
					
					$("#select2").change(function(){
						txt3 += "<option>분류3</option>\n"
						for(i = 0; i < count; i++){
							if($(this).val() == data.data[i].parent){
								txt3 += "<option value='"+ data.data[i].uid +"'>"+ data.data[i].name + "</option>\n";
							}
						}
						
						
						$("#select3 option").siblings().remove();
						$("#select3").html(txt3);
						$("#select3").removeAttr("disabled") 
						txt3 = "";
						
						
					}
					
					
				)}
				
			}
		}
		
	
	
	})
})












