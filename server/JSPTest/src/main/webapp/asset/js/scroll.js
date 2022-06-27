//javascript > js > scroll.js

//1. <div id="bar"></div> 동적 추가
//2. CSS 적용
//3. 이벤트 추가

//<body onload="">
$(document).ready(function() {

    //1 + 2.
    $('<div id="scroll-bar-indicator"></div>')
        .css({
            width: 0,
            height: '5px',
            backgroundColor: 'cornflowerblue',
            position: 'fixed',
            left: 0,
            top: 0,
            border: '0px',
            padding: 0,
            margin: 0
        })
        .prependTo($('body'));

    //3.
    $(document).scroll(function() {

        let x = $(document).scrollTop() * 100 / ($(document).outerHeight() - $(window).outerHeight());
        $('#scroll-bar-indicator').css('width', x + '%');

    });
});

