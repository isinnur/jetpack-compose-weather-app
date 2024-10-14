package com.example.weatherapp

import android.icu.text.AlphabeticIndex.Bucket.LabelType
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}

@Preview
@Composable
fun WeatherScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.horizontalGradient(
                colors = listOf(
                        Color(android.graphics.Color.parseColor("#59469d")),
                    Color(android.graphics.Color.parseColor("#643d67")
                        ))
            )
        ))
    {
        Column(modifier = Modifier.fillMaxSize()){
            LazyColumn(modifier = Modifier.fillMaxSize(),
                                    horizontalAlignment = Alignment.CenterHorizontally) {
                item {
                    Text(text = "Mostly Cloudy",
                        fontSize = 20.sp,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 48.dp),
                        textAlign = TextAlign.Center
                        )

                    Image(painter = painterResource(id = R.drawable.cloudy_sunny),
                     contentDescription = null,
                        modifier = Modifier.size(150.dp)
                            .padding(top = 8.dp))

                    // Display date and time
                    Text(text = "Mon November 14 | 12.00 PM",
                        fontSize = 19.sp,
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth()
                            .padding(top = 8.dp),
                        textAlign = TextAlign.Center
                        )

                    //Display temperature details
                    Text(text = "25°",
                        fontSize = 63.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth()
                            .padding(top = 8.dp),
                        textAlign = TextAlign.Center
                        )
                    Text(text = "H:27 L:18",
                    fontSize = 16.sp,
                    color = Color.White,
                        modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                        textAlign = TextAlign.Center
                    )

                    //Box contain weather details like rain, wind speed, humidity
                    Box(modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp).padding(top = 8.dp)
                        .background(color = colorResource(id = R.color.purple),
                            shape = RoundedCornerShape(25.dp))

                    ) {
                        Row (modifier = Modifier.fillMaxWidth()
                            .height(100.dp)
                            .padding(horizontal = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween){
                            WeatherDetailItem(icon = R.drawable.rain, value = "22%" , labelType = "Rain")
                            WeatherDetailItem(icon = R.drawable.wind, value = "22%" , labelType = "Wind Speed")
                            WeatherDetailItem(icon = R.drawable.humidity, value = "18%" , labelType = "humidity")
                        }
                    }
                    //Displaying "Today" label
                    Text(
                        text = "Today",
                        fontSize = 20.sp,
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp, vertical = 8.dp)
                    )

                }

                //Display future hourly forecast using a LazyRow
                item {
                    LazyRow(modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)

                    ) {
                        item {

                        }
                    }
                }



            }


        }
    }
}
// sample hourly data
val items = listOf(

)


@Composable
fun WeatherDetailItem(icon:Int, value: String, labelType: String) {
    Column(modifier = Modifier.padding(16.dp) , horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = icon) , contentDescription = null,
modifier = Modifier.size(34.dp))
        Text(
            text = value,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.white),
            textAlign = TextAlign.Center
        )

        Text(
            text = labelType,
            color = colorResource(id = R.color.white),
            textAlign = TextAlign.Center
        )


    }
}