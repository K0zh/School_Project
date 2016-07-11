function initMap() {
	if (navigator.geolocation) {
		// 위치정보 얻어옴
		navigator.geolocation
				.getCurrentPosition(function(position) {
					var lat_result = position.coords.latitude, // 위도
					lng_result = position.coords.longitude;// 경도

					var map;
					map = new google.maps.Map(document.getElementById('map'), { // 구글 맵
						// 좌표 설정
						center : {
							lat : lat_result,
							lng : lng_result
						},
						zoom : 16
					});

					var geocoder = new google.maps.Geocoder();

					document.getElementById('submit').addEventListener('click',
							function() {
								geocodeAddress(geocoder, map);

							});

					/* 마커 띄우기 */
					for (i = 0; i < address.length; i++) {
						var myLatLng = new google.maps.LatLng(init_lat[i],
								init_lng[i]);

						if (marker_type[i] == "able") {
							var marker_icon = "resources/images/blue_marker.png";
						} else if (marker_type[i] == "need") {
							var marker_icon = "resources/images/red_marker.png";
						}
						addMarkerWithTimeout(myLatLng, i * 300, i, map,
								marker_icon);
					}
				});
	} else { // HTML5의 GeoLocation을 사용할 수 없을때 실행
	}
}

function geocodeAddress(geocoder, resultsMap) {
	var location = document.getElementById('location_search').value;
	geocoder.geocode({
		'address' : location
	}, function(results, status) {
		if (status === google.maps.GeocoderStatus.OK) {
			resultsMap.setCenter(results[0].geometry.location);
			deleteMarkers();
			
			/*$.ajax({
		        url : "/location.do",
		        type: "get",
		        data : { "id" : $("#id").val() },
		        success : function(responseData){
		            $("#ajax").remove();
		            var data = JSON.parse(responseData);
		            if(!data){
		                return false;
		            }
		        }
		    });*/

		} else {
			alert('Geocode was not successful for the following reason: '
					+ status);
		}
	});
}

// 딜레이 애니메이션 마커
function addMarkerWithTimeout(position, timeout, i, map, marker_icon) {
	window.setTimeout(function() {
		var marker = new google.maps.Marker({
			position : position,
			map : map,
			icon : marker_icon,
			label : {
				text : String(i + 1),
				color : "white",
				fontSize : "25px",
				fontWeight : "bold"
			},
			title : address[i],
			animation : google.maps.Animation.DROP
		});
		
		
		contentInfo(marker, contentString[i]);
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

//마커 초기화 부분
function setMapOnAll(map) {
	for (var i = 0; i < markers.length; i++) {
		markers[i].setMap(map);
	}
}

function clearMarkers() {
	setMapOnAll(null);
}

function deleteMarkers() {
	clearMarkers();
	markers = [];
}