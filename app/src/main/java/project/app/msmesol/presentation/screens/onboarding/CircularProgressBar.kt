package project.app.msmesol.presentation.screens.onboarding

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.clickable

@Composable
fun CircularProgressBar(
    percentage: Float,
    navController: NavController,
    radius: Dp = 25.dp,
    color: Color = Color.Black,
    strokeWidth: Dp = 5.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0,
    navigateTo: String
) {

    var animationPlayed by remember {
        mutableStateOf(false)
    }
    val curPercentage by animateFloatAsState(
        targetValue = if (animationPlayed) percentage else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = animDelay
        )
    )

    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(radius * 2f)
            .clickable {
                navController.navigate(navigateTo)
            }
    ) {
        Canvas(modifier = Modifier.size(radius * 2f)) {
            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = 360 * curPercentage,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }
        Card(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            shape = CircleShape
        ) {
            Row(modifier = Modifier.padding(all = 8.dp)) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
