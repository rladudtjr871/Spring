
//1. <div id="bar"></div> 동적 추가
//2. CSS 적용
//3. 이벤트 추가


//<body onload=""> = ready()
$(document).ready(function() {

    //이렇게 계속 쓰는건 id를 길게 주면 충돌이 생길 확률이 낮아져서 좋다.
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
        // console.log($(document).scrollTop);

        //문서의 세로 길이(스크롤바의 최대위치): 100% = 스크롤바 위치: x%

        //현재 스크롤 위치 * 100 / 맨 밑 스크롤 위치
        let x = $(document).scrollTop() * 100 / ($(document).outerHeight() - $(window).outerHeight());
        $('#scroll-bar-indicator').css('width', x + '%');
        
    });
});

