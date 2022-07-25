
$(document).ready(function(e){
                $("#add-post-form").on("submit", function(event){
                    event.preventDefault();
                    console.log("Submitted");
                    let form = new FormData(this);
                    $.ajax({
                        url: "SavePost",
                        type:'POST',
                        data: form,
                        success: function(data,textStatus, jqXHR){
                            console.log(data);
                            if(data.trim() == 'done'){
                                swal("Good job!", "Saved Successfully!", "success").then((value)=>{window.location="allPosts.jsp";})
                            }else{
                                swal("Error!", "Something went wrong try again..", "error");
                            }
                        },
                        error: function(jqXHR, textStatus, errorThrown){
                            swal("Error!", "Something went wrong try again..", "error");
                        },
                        processData: false,
                        contentType: false
                    })
                });
            });
