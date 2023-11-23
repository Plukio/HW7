package com.example.hw7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hw7.ui.theme.HW7Theme

class MainActivityCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { HW7Theme { ComposeLayout() } }
    }
}

@Composable
@Preview
fun ComposeLayout() {

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        item { MainImage() }

        item {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)) {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Profile()
                        }
                    }

                    item { Icons() }
                }
            }
        }

        item { DivideLine() }

        item { DetailsSection() }

        item { DivideLine() }

        item { StatsSection() }

        item { DivideLine() }

        item { ButtonsSection() }
    }
}



@Composable
fun MainImage() {
    Box(modifier = Modifier
        .height(300.dp)
        .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.main_image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(18.dp)
            .align(Alignment.BottomStart),
            ){
            Location()

        }

    }
}

@Composable
fun Profile() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(text = "Android", color = Color.White, fontSize = 20.sp)
    }
}

@Composable
fun Location() {
    Row(
        modifier = Modifier.wrapContentWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.pin),
            contentDescription = null,
            modifier = Modifier
                .size(30.dp),
            contentScale = ContentScale.Inside
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(text = "Bangkok", color = Color.White, fontSize = 20.sp)
    }
}

@Composable
fun Icons() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconButton(onClick = { /*TODO*/ }) {
            Image(
                painter = painterResource(id = R.drawable.upload),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp),
                contentScale = ContentScale.Inside
            )
        }


        Spacer(modifier = Modifier.width(12.dp))

        IconButton(onClick = { /*TODO*/ }) {
            Image(
                painter = painterResource(id = R.drawable.like),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp),
                contentScale = ContentScale.Inside
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        IconButton(onClick = { /*TODO*/ }) {
            Image(
                painter = painterResource(id = R.drawable.bookmark),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp),
                contentScale = ContentScale.Inside
            )
        }
    }
}


@Composable
fun DetailsSection() {

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.Start) {
            DetailColumn("Camera", "NOKIA 330")
            DetailColumn("Focal Length", "15.0mm")
            DetailColumn("ISO", "100")
        }

        Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.Start) {
            DetailColumn("Apature", "f/5.0")
            DetailColumn("Shutter Speed", "1/125s")
            DetailColumn("Dimensions", "3903x4882")
        }
    }
}

@Composable
fun DetailColumn(statName: String, statValue: String) {
    Column(
        horizontalAlignment = Alignment.Start,
    ) {
        Text(text = statName, color = Color.White, fontSize = 16.sp)
        Text(text = statValue, color = Color.Gray, fontSize = 18.sp, textAlign = TextAlign.Center)
    }
}

@Composable
fun StatsSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp, 16.dp, 12.dp, 16.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        StatColumn("Views", "10.2M")
        StatColumn("Downloads", "108.3K")
        StatColumn("Likes", "4.5K")
    }
}

@Composable
fun StatColumn(statName: String, statValue: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = statName, color = Color.White, fontSize = 16.sp)
        Text(text = statValue, color = Color.White, fontSize = 18.sp, textAlign = TextAlign.Center)
    }
}



@Composable
fun DivideLine() {
    Row(modifier = Modifier.padding(18.dp, 0.dp, 18.dp, 0.dp)) {
        Divider(color = Color.Gray, thickness = 0.5.dp)
    }
}

@Composable
fun ButtonsSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = { /* */},
            modifier = Modifier
                .height(40.dp)
                .wrapContentWidth()
                .clip(RoundedCornerShape(25.dp)),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.tranparence))
        ) {
            Text(text = "Bangkok", color = Color.White, fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.width(12.dp))

        Button(
            onClick = { /* */},
            modifier = Modifier
                .height(40.dp)
                .wrapContentWidth()
                .clip(RoundedCornerShape(25.dp)),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.tranparence))
        ) {
            Text(text = "Thailand", color = Color.White, fontSize = 14.sp)
        }
    }
}
