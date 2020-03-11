<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
	box-sizing: border-box;
}

body {
	font-family: Verdana, sans-serif;
}

.mySlides {
	display: none;
}

img {
	vertical-align: middle;
}

/* Slideshow container */
.slideshow-container {
	max-width: 1000px;
	position: relative;
	margin: auto;
}

/* Caption text */
.text {
	color: #f2f2f2;
	font-size: 15px;
	padding: 8px 12px;
	position: absolute;
	bottom: 8px;
	width: 100%;
	text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
	color: #f2f2f2;
	font-size: 12px;
	padding: 8px 12px;
	position: absolute;
	top: 0;
}

/* The dots/bullets/indicators */
.dot {
	height: 15px;
	width: 15px;
	margin: 0 2px;
	background-color: #bbb;
	border-radius: 50%;
	display: inline-block;
	transition: background-color 0.6s ease;
}

.active {
	background-color: #717171;
}

/* Fading animation */
.fade {
	-webkit-animation-name: fade;
	-webkit-animation-duration: 1.5s;
	animation-name: fade;
	animation-duration: 1.5s;
}

@
-webkit-keyframes fade {
	from {opacity: .4
}

to {
	opacity: 1
}

}
@
keyframes fade {
	from {opacity: .4
}

to {
	opacity: 1
}

}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
	.text {
		font-size: 11px
	}
}
</style>
</head>
<body>



	<div class="slideshow-container">

		<div class="mySlides fade">
			<center>
				<img src="assets/images/i1.png" style="width: 30%">
			</center>
		</div>

		<div class="mySlides fade">
			<center>
				<img src="assets/images/i2.png" style="width: 30%">
			</center>
		</div>

		<div class="mySlides fade">
			<center>
				<img src="assets/images/i3.png" style="width: 30%">
			</center>
		</div>
		<div class="mySlides fade">
			<center>
				<img src="assets/images/i4.png" style="width: 30%">
			</center>
		</div>
		<div class="mySlides fade">
			<center>
				<img src="assets/images/i5.png" style="width: 30%">
			</center>
		</div>
		<div class="mySlides fade">
			<center>
				<img src="assets/images/i6.png" style="width: 30%">
			</center>
		</div>
		<div class="mySlides fade">
			<center>
				<img src="assets/images/i7.png" style="width: 30%">
			</center>
		</div>
		<div class="mySlides fade">
			<center>
				<img src="assets/images/i8.png" style="width: 30%">
			</center>
		</div>
		<div class="mySlides fade">
			<center>
				<img src="assets/images/i10.png" style="width: 30%">
			</center>
		</div>
	</div>
	<br>

	<div style="text-align: center">
		<span class="dot"></span> <span class="dot"></span> <span class="dot"></span>
		<span class="dot"></span> <span class="dot"></span> <span class="dot"></span>
		<span class="dot"></span> <span class="dot"></span> <span class="dot"></span>
	</div>

	<script>
		var slideIndex = 0;
		showSlides();

		function showSlides() {
			var i;
			var slides = document.getElementsByClassName("mySlides");
			var dots = document.getElementsByClassName("dot");
			for (i = 0; i < slides.length; i++) {
				slides[i].style.display = "none";
			}
			slideIndex++;
			if (slideIndex > slides.length) {
				slideIndex = 1
			}
			for (i = 0; i < dots.length; i++) {
				dots[i].className = dots[i].className.replace(" active", "");
			}
			slides[slideIndex - 1].style.display = "block";
			dots[slideIndex - 1].className += " active";
			setTimeout(showSlides, 2000); // Change image every 2 seconds
		}
	</script>

</body>
</html>
