function initMap() {
	if (navigator.geolocation) {
		// 위치정보 얻어옴
		navigator.geolocation.getCurrentPosition(function(position) {
			var lat_result = position.coords.latitude, // 위도
			lng_result = position.coords.longitude;// 경도

			var map;
			map = new google.maps.Map(document.getElementById('map'), { // 구글 맵
				// 좌표 설정
				center : {
					lat : lat_result,
					lng : lng_result
				},
				zoom : 18
			});

			/* 마커 띄우기 */
			for (i = 0; i < address.length; i++) {
				var myLatLng = new google.maps.LatLng(init_lat[i],
						init_lng[i]);
				
				addMarkerWithTimeout(myLatLng, i*500, i, map);
				/*var marker = new google.maps.Marker({
					position : myLatLng,
					map : map,
					label : String(i+1),
					title : address[i]
				});
				contentInfo(marker, contentString[i]);*/
			}
		});
	} else { // HTML5의 GeoLocation을 사용할 수 없을때 실행
	}
}
//딜레이 애니메이션 마커
function addMarkerWithTimeout(position, timeout, i, map){
	window.setTimeout(function(){
		var marker = new google.maps.Marker({
			position : position,
			map : map,
			icon:"${pageContext.request.contextPath}/resources/marker_images/blue_marker.png",
			label :{text : String(i+1),
					color:"white",
					fontSize:"25px",
					fontWeight:"bold"
			},
			title : address[i],
			animation: google.maps.Animation.DROP
		});
		contentInfo(marker,contentString[i]);
	}, timeout);
}

function contentInfo(marker, contentString) {
	
	/* 마커 정보창 */
	var infowindow = new google.maps.InfoWindow({
		content : contentString, // 정보 내용
		maxWidth : 200
	});

	/* 마커 클릭시 정보창 띄우기 */
	marker.addListener('click', function() {
		infowindow.open(marker.get('map'), marker);
	});
}
