var markers = [];
function initMap() {
	var lat_result, lng_result;
	
	if (navigator.geolocation) {
		// 위치정보 얻어옴
		navigator.geolocation.getCurrentPosition(function(position) {
			lat_result = position.coords.latitude, // 위도
			lng_result = position.coords.longitude;// 경도

			var myLatLng = {
				lat : lat_result,
				lng : lng_result
			}

			myMap(myLatLng)

		});

	} else { // HTML5의 GeoLocation을 사용할 수 없을때 실행
		alert("지오로케이션 사용 불가");
	}
}

function myMap(myLatLng) {
	var map;
	var geocoder = new google.maps.Geocoder;
	map = new google.maps.Map(document.getElementById('map'), { // 구글 맵
		// 좌표 설정
		center : myLatLng,
		zoom : 18
	});

	google.maps.event.addListener(map, 'click', function(event) {
		deleteMarkers()
		var marker = new google.maps.Marker({
			position : event.latLng,
			map : map
		});
		markers.push(marker);
		document.getElementById("location").value = event.latLng;

		var input = document.getElementById('location').value;
			input = input.replace("(","").replace(")","");
		
		var latlngStr = input.split(',', 2);
			
		var latlng = {
			lat : parseFloat(latlngStr[0]),
			lng : parseFloat(latlngStr[1])
		};
		console.log(latlngStr[0])
		console.log(latlngStr[1])
		console.log(document.getElementById('location').value)
		console.log(latlng)
		geocoder.geocode({
			'location' : latlng
		}, function(results, status) {
			if (status === google.maps.GeocoderStatus.OK) {
				if (results[1]) {
					document.getElementById("address").value =  results[1].formatted_address
				} else {
					window.alert('No results found');
				}
			} else {
				window.alert('Geocoder failed due to: ' + status);
			}
		});
	});
}

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