package com.example.university_project

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.mutableStateSetOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.university_project.ui.theme.UniversityprojectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UniversityprojectTheme {
                DiceRollerApp()


            }
        }
    }
}

@Composable
fun DiceRollerApp(){  // Parent
    DiceWithButtonAndImage(modifier =Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )// Child Composable

}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier= Modifier){

    var imageResource by remember {mutableStateOf  (value=1)}//state
    var image=painterResource(R.drawable.dice_1)
    when(imageResource){
        1->image=painterResource(id=R.drawable.dice_1)
        2->image=painterResource(id=R.drawable.dice_2)
        3->image=painterResource(id=R.drawable.dice_3)
        4->image=painterResource(id=R.drawable.dice_4)
        5->image=painterResource(id=R.drawable.dice_5)
        6->image=painterResource(id=R.drawable.dice_6)

    }

    Column(
        modifier=modifier,
        horizontalAlignment= Alignment.CenterHorizontally
    ){
        Image(
            painter = image,
            contentDescription = null
        )
        Spacer(modifier= Modifier.size(48.dp))
        Button(onClick={imageResource=(1..6).random()}){
            Text("Roll")
        }
    }
}


