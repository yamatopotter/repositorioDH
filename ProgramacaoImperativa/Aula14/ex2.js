var weather = require('weather-js');

weather.find({search:'Itaguaí, RJ, Brazil', degreeType:'C'}, function(err, result) {
    if(err) console.log(err);
   
    console.log(JSON.stringify(result, null, 2));
  });