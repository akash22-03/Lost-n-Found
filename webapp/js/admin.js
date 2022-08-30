
$(document).ready(function(e){
                $('#add-admin-form').on('submit', function(event){
                    event.preventDefault();
					console.log("Submitted");
                    let form = new FormData(this);
                    $.ajax({
                        url: "SaveAdmin",
                        type:"POST",
                        data: form,
                        processData: false,
                        contentType: false,
                        success: function(data,textStatus, jqXHR){
                            if(data.trim() == 'done'){
                                swal("Good job!", "Saved Successfully!", "success")
                            }else{
                                swal("Error!", "Something went wrong try again..", "error");
                            }
                        },
                        error: function(jqXHR, textStatus, errorThrown){
                            swal("Error!", "Something went wrong try again..", "error");
                        },

                    })
                });
            });

