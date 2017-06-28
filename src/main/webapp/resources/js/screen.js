var uaString = window.navigator.userAgent;
var ie9 = false;
if (uaString.indexOf("MSIE 9") != -1){
	ie9 = true;
}

// onload
$(window).load(function () {
	
});


// ready 
$(function () {
	// select box
	//$('select').selectbox(); 2017-04-25 select 박스 default로 수정
	//table_child();

	//login input click text
	$('.loginForm .inputLabel').on('click', function(e){
		$(this).css('display','none');
		$(this).next().focus();
	});
	$('.loginForm .text').on('focus', function(e){
		$(this).prev().css('display','none');
	});
	$('.loginForm input').on('blur', function(e){
		if ( $(this).val() == "" ){
			$(this).prev().show(); 
		}
	});
	// 아이디 값이 있을때 2017-05-12 수정
	if ( $('.loginForm #userId').val() == "" ){
		$('.loginForm #userId').prev().show(); 
	}else{
		$('.loginForm #userId').prev().hide(); 
	}



	// main slider
	if ($('.mainSlider').length != 0) {
		$('.mainSlider .slider').bxSlider({
			adaptiveHeight: true,
			auto: true,
			pause: 4000,
			ease: 'easeOutElastic'
		});
	}

	// 2017-05-08 게임 맵 롤링 
	
		$('.imgGuide .slider').bxSlider({
			adaptiveHeight: true,
			auto: true,
			pause: 100,
			ease: 'easeOutElastic',
			infiniteLoop: false,
		});

		
		


	//main game list - over text 2017-05-15 overtxt 수정 2017-05-17 원복
	$('.s_gameList a').mouseover(function() {
		$('.s_gameList .overText ').removeClass('active');
		$(this).parent().find('.overText').addClass('active').fadeIn('300');
		
	});
	$('.overText').mouseleave(function (e) {
		$(this).toggleClass('active').fadeOut('300');
		
	});

	// main game list - toggle
	$('.mGameList .depthTit').click(function(){
		$('.mGameList li').each(function(idx){
			$(this).removeClass('active');
			$(this).find('.s_gameList ').stop().slideUp(300);
		});
		$(this).parent().addClass('active');
		$(this).next().stop().slideToggle('300');
	});
	$('.mGameList li').eq(0).addClass('active');
	$('.mGameList li').eq(0).find('.s_gameList ').stop().slideDown(300);

	//회원가입 - 주소 - 국내, 국외
	$('.addrBox input').click(function(){
		
		if($('input#domestic').is(":checked")){
			$('.domestic').show();
			$('.oversea').hide();
		}else{
			$('.domestic').hide();
			$('.oversea').show();
		}
	});
	
	//회원가입 - 회원 유형 선택 - 2017-04-24 개발팀요청주석 처리
	//$('.typeUser #userNormal').click(function(){
	//	$('.userNormalCont').css('display','block');
	//	$('.userFamilyCont').css('display','none');
	//});
	//$('.typeUser #userFamily').click(function(){
	//	$('.userFamilyCont').css('display','block');
	//	$('.userNormalCont').css('display','none');
	//});
	
	// 음운인식 레벨 선택 - 2017-05-08 개발팀요청 주석처리 
	//$('.mapIntro li').click(function(){
	//	$(this).addClass('on').siblings('li').removeClass('on');
	//});

	// 캐릭터 소개
		$('.intrChar li').mouseover(function(){
			var hSpan = $(this).children('span').height();		
			$(this).children('span').css({'margin-top':-hSpan/2,'padding-top':'75px'});
		});


	//마이페이지 - 유형테스트 히스토리
	$(".historyList dt").click(function(){
		$(".historyList dt").each(function(){
			$(this).removeClass("on");
		});
		$(this).addClass("on");
		$(this).next().slideToggle("300", function(){
			if($(this).css("display") == "none"){
				$(this).prev().removeClass("on");
			}
		});
		$(".historyList dt").each(function(idx, el){
			if(!$(this).hasClass("on")){
				$(this).next().css("display", "none");
			}
		});
	});
	$('.historyList dt').eq(0).addClass('on');
	$('.historyList dd').eq(0).addClass('active');

});

	/*2017-04-28 홍식과장님이 호출함수 요청함*/
	function goMapLink() {
		location.href='/dyslexia/gameMap.do';
	}
// layerPopup
$(document).ready(function(){
	//ShowModalPopup('layer'); //버튼클릭없고 그냥 띄울때
});
//레이어 가운데로  - 2017-05-17 배경 fixed
var _ModalPopupBackgroundID = 'modal';
function ShowModalPopup(modalPopupID) {
	var popupID = "#" + modalPopupID;
	var popupMarginTop = $(popupID).height() / 2;
	var popupMarginLeft = $(popupID).width() / 2;
	$(popupID).fadeIn();
	$(popupID).css({
		'left': '50%',
		'top': '50%',
		'margin-top': -popupMarginTop,
		'margin-left': -popupMarginLeft,
		'position': 'fixed',
		'z-index': 9999
	});

	var backgroundSelector = $('<div id="' + _ModalPopupBackgroundID + '" ></div>');
	backgroundSelector.appendTo('body');

	backgroundSelector.css({
		'width': $(document).width(),
		'height': $(document).height(),
		'display': 'none',
		'background-color': '#000',
		'filter':'alpha(opacity=50)',
		'position': 'absolute',
		'top': 0,
		'left': 0,
		'z-index': 9998
	});
	backgroundSelector.fadeTo('fast', 0.7);

	$('body').css('position','fixed');
}
//레이어 닫기 2017-05-17 배경 fixed
function HideModalPopup(modalPopupID) {
	$("#" + modalPopupID).hide();
	$("#" + _ModalPopupBackgroundID).remove();

	$('body').css('position','static');
}