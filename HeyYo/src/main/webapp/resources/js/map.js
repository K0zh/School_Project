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
				var marker = new google.maps.Marker({
					position : myLatLng,
					map : map,
					title : address[i]
				});
				contentInfo(marker, contentString[i]);
			}
		});
	} else { // HTML5의 GeoLocation을 사용할 수 없을때 실행
	}
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
