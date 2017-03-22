function tdClick(abc){
	var td=document.getElementById(abc);
	if (td.className == "present"){
		td.className = "absent";
		document.getElementById("std" + abc).value=0;
	}else{
		td.className = "present";
		document.getElementById("std" + abc).value=1;
	}
}

function allPresent(){
	var x = document.getElementsByClassName('absent');	
	//alert("before: " + x.length);
	while(x.length>0){
	x = document.getElementsByClassName('absent');
	document.getElementById("std"+x[0].id).value=1;
	x[0].className='present';  	 
	//alert("after: " + x.length);
	}
}

function allAbsent(){
	var x = document.getElementsByClassName('present');	
	//alert("before: " + x.length);
	while(x.length>0){
	x = document.getElementsByClassName('present');
	document.getElementById("std"+x[0].id).value=0;
	x[0].className='absent';  	 
	//alert("after: " + x.length);
	}
}


/*$(document).ready(function(){
  $(".attendence_table td").click(function(){
    $(this).toggleClass("absent");
  });
   $(".all-present").click(function(){
    $(".attendence_table td").toggleClass("absent");		
  });  
  $( "#datepicker" ).datepicker();
  
  
  
});

$(document).ready(function(){
	  $(".attendence_table td").click(function(){
	    $(this).toggleClass("absent");
		
	  });
	   $(".all-present").click(function(){
	    $(".attendence_table td").toggleClass("absent");		
	  });  

	});

$(document).ready(function(){
	$(".attendence_table td").click(function(){
		$(this).toggleClass("absent");
		var elem = $(this).attr('elemment');
		var cls = $(this).attr('class');
		 alert(elm);
		 alert ('yes');
		 if(cls == 'present absent'){
			
		 	document.getElementById(elem).value = 0;
		 }else{
		 	document.getElementById(elem).value = 1;
		 }
	  });
	  
	   $("#all_absent").click(function(){ 
	  		$(".present").each(function() {
				//test
				//$(this).removeClass('present');
				$(this).addClass('absent');
				//alert(this);
			});
			
			$(".std").each(function() {
				$(this).attr('value','0');
				//alert(this);
			});
			
	  });
	
		$("#all_present").click(function(){ 
	  		$(".absent").each(function() {
				$(this).removeClass('absent');
			});
			
			$(".std").each(function() {
				$(this).attr('value','1');
			});
			
	  });
	  

	});

$(function() {
    $('#stepExample1').timepicker({ 'step': 15 });
	$('#stepExample2').timepicker({ 'step': 15 });
    
});

$(document).ready(function(){
	  $(".attendence_table td").click(function(){
	    $(this).toggleClass("absent");
		
	  });
	   $(".all-present").click(function(){
	    $(".attendence_table td").toggleClass("absent");		
	  });  
	 
	});

function myFunction() {
    alert("Hello! I am an alert box!");
}*/