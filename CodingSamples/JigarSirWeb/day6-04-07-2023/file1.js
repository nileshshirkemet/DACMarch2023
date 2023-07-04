console.log($);
$("button").click(function () {
  console.log("click working");
  var categoryname = $("#x3").val()
  console.log(categoryname);
  var apipath = `https://fakestoreapi.com/products/category/${categoryname}`
  console.log(apipath);
  $.ajax({
    type: "get",
    url: apipath,
    success: function (response) {
      console.log(response);
    }
  })
})
