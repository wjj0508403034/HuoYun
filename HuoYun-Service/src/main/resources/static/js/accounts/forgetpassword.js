$(document).on("click", ".change-way a", function() {
	if ($(this).hasClass("by-email")) {
		$(".find-by-email").addClass("hidden");
		$(".find-by-phone").removeClass("hidden");
	} else {
		$(".find-by-email").removeClass("hidden");
		$(".find-by-phone").addClass("hidden");
	}
});