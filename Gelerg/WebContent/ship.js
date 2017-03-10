/**
 * 
 */

function Ship(parant, posX, posY, width, height){
	this.parant = parant;	//배가 위치할 부모
	this.posX = posX;
	this.posY = posY;
	this.width = width;
	this.height = height;
	
	//배가 사용할 이미지, 스판, 이동거리
	this.img;
	this.span;
	this.stepX = 0;
	
	this.init = function(){
		//span요소 생성
		//위치할 좌표와 크기를 포함해서 각종 style값 적용
		//img요소 생성해서 이미지 사진 맞추고 크기 맞추고
		//img를 span에 span을 parant에 넣기
		this.span = document.createElement("span");
		this.span.style.width = this.width + "px";
		this.span.style.height = this.height + "px";
		this.span.style.position = "absolute";
		this.span.style.left = this.posX + "px";
		this.span.style.top = this.posY + "px";
		
		this.img = document.createElement("img");
		this.img.src = "./img/ship.png";
		this.img.style.width = this.width + "px";
		this.img.style.height = this.height + "px";
		
		this.span.appendChild(this.img);
		this.parant.appendChild(this.span);
	};
	
	this.move = function(){
		var me = this;
		this.posX = this.posX + this.stepX;
		this.span.style.left = this.posX + "px";
		setTimeout(function() {
			me.move();
		}, 10);
	};
}