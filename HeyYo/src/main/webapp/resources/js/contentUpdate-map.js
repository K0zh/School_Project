var markers = [];

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