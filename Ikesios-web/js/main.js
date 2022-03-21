
//jQuery time
// 16 - 21 - 15

// Status Report Util
var now = new Date();

var day = ("0" + now.getDate()).slice(-2);
var month = ("0" + (now.getMonth() + 1)).slice(-2);

var today = now.getFullYear() + "-" + (month) + "-" + (day);
$("input[name='conf_date']").val(today);
$("input[name='eis_date']").val(today);

var covid_confirm = $("select[name ='covid_confirm']").change(function () {
	var selected_value = $(this).val();

	if (selected_value != "c-1") {
		$(".covid_extras").show();
		$("input[name ='covid_confirm_extra']").prop('required', true);
	} else {
		$(".covid_extras").hide();
		$("input[name ='covid_confirm_extra']").prop('required', false);
	}
})
$("#dhlosh_astheneias").submit(function (e) {
	e.preventDefault();
	Swal.fire(
		'Επιτυχία',
		'Η δήλωση σας αναφέρθηκε!',
		'success'
	);

});

// 
$("input[value='hd-4']").change(function () {
	if (this.checked) {
		$(".hd-5-box").show();
		$("input[name ='hd-5']").prop('required', true);
	} else {
		$(".hd-5-box").hide();
		$("input[name ='hd-5']").prop('required', false);
	}
});

$("input[value='rd-7']").change(function () {
	if (this.checked) {
		$(".rd-7-box").show();
		$("input[name ='rd-8']").prop('required', true);
	} else {
		$(".rd-7-box").hide();
		$("input[name ='rd-8']").prop('required', false);
	}
});

var relation = $("select[name ='relation']").change(function () {
	var selected_value = $(this).val();

	if (selected_value != "me") {
		$(".related-optional").show();
		$("input[name ='rel-who']").prop('required', true);
		$("input[name ='rel-age']").prop('required', true);
		$("input[name ='rel-gender']").prop('required', true);
		$("input[name ='rel-loc']").prop('required', true);
		$("input[name ='rel-name']").prop('required', true);

	} else {
		$(".related-optional").hide();
		$("select[name ='rel-who']").prop('required', false);
		$("input[name ='rel-age']").prop('required', false);
		$("input[name ='rel-gender']").prop('required', false);
		$("input[name ='rel-loc']").prop('required', false);
		$("input[name ='rel-name']").prop('required', false);
	}
})
$("#dhlosh_katastashs").submit(function (e) {
	e.preventDefault();
	Swal.fire(
		'Επιτυχία',
		'Η κατάσταση σας αναφέρθηκε!',
		'success'
	);

});

// nCovid-2019 Symptoms Check Util

// Note: This is just a simple on-site check algorithm
// When we finish the algorithm, it will be hosted on our
// main server and the symtoms will be redirected there
// in order to be checked and the result will be returned

// Note2 (04/04/20): Our check algorithm may differ from this one 

var step = 0;
var current_fs, next_fs, previous_fs; //fieldsets
var left, opacity, scale; //fieldset properties which we will animate
var animating; //flag to prevent quick multi-click glitches

$(".next").click(function () {
	if (animating) return false;

	if (!$('input[name=dry_cough]').is(':checked') && step == 0) { return false; }
	if (!$('input[name=fever]').is(':checked') && step == 1) { return false; }
	if (!$('input[name=stuffy_nose]').is(':checked') && step == 2) { return false; }
	if (!$('input[name=sore_throat]').is(':checked') && step == 3) { return false; }
	if (!$('input[name=shortness_of_breath]').is(':checked') && step == 4) { return false; }
	if (!$('input[name=head_ache]').is(':checked') && step == 5) { return false; }
	if (!$('input[name=body_aches]').is(':checked') && step == 6) { return false; }
	if (!$('input[name=sneezing]').is(':checked') && step == 7) { return false; }
	if (!$('input[name=exhaustion]').is(':checked') && step == 8) { return false; }
	if (!$('input[name=diarrhea]').is(':checked') && step == 9) { return false; }
	animating = true;
	step++;

	current_fs = $(this).parent();
	next_fs = $(this).parent().next();

	//activate next step on progressbar using the index of next_fs
	$("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");

	//show the next fieldset
	next_fs.show();
	//hide the current fieldset with style
	current_fs.animate({ opacity: 0 }, {
		step: function (now, mx) {
			//as the opacity of current_fs reduces to 0 - stored in "now"
			//1. scale current_fs down to 80%
			scale = 1 - (1 - now) * 0.2;
			//2. bring next_fs from the right(50%)
			left = (now * 50) + "%";
			//3. increase opacity of next_fs to 1 as it moves in
			opacity = 1 - now;
			current_fs.css({
				'transform': 'scale(' + scale + ')',
				'position': 'absolute'
			});
			next_fs.css({ 'left': left, 'opacity': opacity });
		},
		duration: 800,
		complete: function () {
			current_fs.hide();
			animating = false;
		},
		//this comes from the custom easing plugin
		easing: 'easeInOutBack'
	});

	if (step == 10) {

		var sum = parseInt($('input[name=dry_cough]:checked').val()) +
			parseInt($('input[name=fever]:checked').val()) +
			parseInt($('input[name=stuffy_nose]:checked').val()) +
			parseInt($('input[name=sore_throat]:checked').val()) +
			parseInt($('input[name=shortness_of_breath]:checked').val()) +
			parseInt($('input[name=head_ache]:checked').val()) +
			parseInt($('input[name=body_aches]:checked').val()) +
			parseInt($('input[name=sneezing]:checked').val()) +
			parseInt($('input[name=exhaustion]:checked').val()) +
			parseInt($('input[name=diarrhea]:checked').val());//+ $('#fever').val()); 
		covid19_chance = (sum / 16) * 100;
		flu_chance = (sum / 21) * 100;
		cold_chance = (sum / 15) * 100;

		if (covid19_chance < 0) {
			$("#covid19_result").html("Δεν είστε συμβατός με τον <strong>nCov-2019</strong>");
			$("#covid19_result").addClass("alert-success");
		} else {
			$("#covid19_result").html("Συμβατότητα με nCov-2019: <strong>" + covid19_chance.toFixed(3) + "%</strong>");

			if (covid19_chance >= 100) {
				$("#covid19_result").addClass("alert-danger");
				$("#covid19_result").html("Υψηλή συμβατότητα με τον <strong>nCov-2019</strong>");
			}
			else if (covid19_chance > 85) {
				$("#covid19_result").addClass("alert-danger");
			}
			else if (covid19_chance > 50) {
				$("#covid19_result").addClass("alert-info");
			}
			else {
				$("#covid19_result").addClass("alert-success");
			}
		}

		if (flu_chance < 0) {
			$("#flu_result").html("Δεν είστε συμβατός με τη <strong>Γρίπη</strong>");
			$("#flu_result").addClass("alert-success");
		} else {
			$("#flu_result").html("Συμβατότητα με Γρίπη <strong>" + flu_chance.toFixed(3) + "%</strong>");

			if (flu_chance >= 100) {
				$("#flu_result").addClass("alert-danger");
				$("#flu_result").html("Υψηλή συμβατότητα με τη <strong>Γρίπη</strong>");
			}
			else if (flu_chance > 85) {
				$("#flu_result").addClass("alert-danger");
			}
			else if (flu_chance > 50) {
				$("#flu_result").addClass("alert-info");
			}
			else {
				$("#flu_result").addClass("alert-success");
			}
		}

		if (cold_chance < 0) {
			$("#cold_result").html("Δεν είστε συμβατός με τo <strong>Κρύωμα</strong>");
			$("#cold_result").addClass("alert-success");
		} else {
			$("#cold_result").html("Συμβατότητα με Κρύωμα <strong>" + cold_chance.toFixed(3) + "%</strong>");

			if (cold_chance >= 100) {
				$("#cold_result").addClass("alert-danger");
				$("#cold_result").html("Υψηλή συμβατότητα με το <strong>Κρύωμα</strong>");
			}
			else if (cold_chance > 85) {
				$("#cold_result").addClass("alert-danger");
			}
			else if (cold_chance > 50) {
				$("#cold_result").addClass("alert-info");
			}
			else {
				$("#cold_result").addClass("alert-success");
			}
		}
		$(".results").removeClass("invisible");
		$("#progressbar").addClass("invisible");


		// alert(covid19_chance + "% " + flu_chance  + "% " + cold_chance + "% ");

	}
});

$(".previous").click(function () {
	if (animating) return false;
	animating = true;
	step--;
	current_fs = $(this).parent();
	previous_fs = $(this).parent().prev();

	//de-activate current step on progressbar
	$("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");

	//show the previous fieldset
	previous_fs.show();
	//hide the current fieldset with style
	current_fs.animate({ opacity: 0 }, {
		step: function (now, mx) {
			//as the opacity of current_fs reduces to 0 - stored in "now"
			//1. scale previous_fs from 80% to 100%
			scale = 0.8 + (1 - now) * 0.2;
			//2. take current_fs to the right(50%) - from 0%
			left = ((1 - now) * 50) + "%";
			//3. increase opacity of previous_fs to 1 as it moves in
			opacity = 1 - now;
			current_fs.css({ 'left': left });
			previous_fs.css({ 'transform': 'scale(' + scale + ')', 'opacity': opacity });
		},
		duration: 800,
		complete: function () {
			current_fs.hide();
			animating = false;
		},
		//this comes from the custom easing plugin
		easing: 'easeInOutBack'
	});
});

$(".submit").click(function () {
	return false;
})
// Help request util
$( "#dhlosh_anagkhs" ).submit(function(e) {
	e.preventDefault();
	Swal.fire(
		'Επιτυχία',
		'Η δήλωση σας αναφέρθηκε!',
		'success'
	  );
	  
  });
  $( "#dhlosh_paroxhs" ).submit(function(e) {
	e.preventDefault();
	Swal.fire(
		'Επιτυχία',
		'Η δήλωση σας αναφέρθηκε!',
		'success'
	  );
	  
  });