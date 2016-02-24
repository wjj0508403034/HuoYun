$(document).on("click", ".tab li", function() {
	var index = $(this).index();
	$(this).parents(".tab").attr("index", index);
	if (index === 1) {
		$(".tab-0").addClass("hidden");
		$(".tab-1").removeClass("hidden");
	} else {
		$(".tab-1").addClass("hidden");
		$(".tab-0").removeClass("hidden");
	}
});