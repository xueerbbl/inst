var screen = true; i = 0; width = 0;
function shiftwindow() {
	if (screen == false) {
		parent.topwin.cols = '173,*';
		screen = true;
	} else if (screen == true) {
		parent.topwin.cols = '0,*';
		screen = false;
	}
}

var show = false;
function stashitem(item) {
	if (show == false) {
		item.style.display = 'none';
		show = true;
	} else if (show == true) {
		item.style.display = '';
		show = false;
	}
}

var timeoutid = null;
function scrollwindow() {
	timeoutid = setTimeout("goToTop()", 1);
}

function goToTop() {
	parent.parent.window.scroll(0, 0);
	if (timeoutid)
		clearTimeout(timeoutid);
}