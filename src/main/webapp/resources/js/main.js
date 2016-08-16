$(document).ready(function() {

	$("#search-form").submit(function(event) {

		// Disble the search button
		
		
		//$(this).find('input[type=submit]').prop('disabled', true);

		// Prevent the form from submitting via the browser.
		event.preventDefault();

		if($("#tagname").val() != ''){
			searchViaAjax();
		}		

	});
	
	$("#tagList").change(function(){
		var selected_id = $(this).find('option:selected').attr('id');
		//alert(selected_id);
		
		toggleContacts(selected_id);
		
	});

});

function toggleContacts(selected_id){
	
	//reset	
	$("#contactsTable tbody tr.contact_items").each(function(index){
		if(!$(this).hasClass('hidden')){
			$(this).addClass('hidden');
		}
	});
		
	$("#contactsTable tbody tr.parent_" + selected_id).each(function(index){
			$(this).toggleClass('hidden');
	});
	
}


function searchViaAjax() {
	enableSearchButton(true);
	
	$.ajax({
		type : "GET",
		url : "search/" + $("#tagname").val(),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			
			display(data.response);
			var trHTML = '';
			
			$.each(data.tags, function (i, tag_item) {
				
				trHTML += '<tr><td>' + tag_item.name + '</td><td>';
				
				$.each(tag_item.contacts, function(j, contact_item){
					trHTML +=  contact_item.fullName + '<br/>';
				});
					trHTML += '</td></tr>';
			});

			$('#tags_table').append(trHTML);

		},
		error : function(e) {
			console.log("ERROR: ", e);
			display(data.response);
		},
		complete : function(e) {
			enableSearchButton(false);
			console.log("Request Completed");
			
		}
	});

}

function enableSearchButton(flag) {
	$("#searchButton").prop("disabled", flag);	
	
}

function display(response) {
	$('#feedback').text(response);
}