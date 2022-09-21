package me.daniil.common.presentation

//import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.daniil.common.data.entity.FieldNet


//@Composable
//@Preview
//fun PreviewMainScreen(){
//    FieldsList(listOf(FieldNet("test","test","test","test",false),
//        FieldNet("test","test2","test","test",false),
//        FieldNet("test","test3","test","test",false),
//        FieldNet("test","test4","test","test",false)))
//}

@Composable
fun MainScreen(viewModel: MainScreenViewModel) {
    Column {
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Button(
                modifier = Modifier.padding(4.dp),
                onClick = {
                viewModel.loadFields(false)
            }) {
                Text("Load list")
            }
            Button(
                modifier = Modifier.padding(4.dp),
                onClick = {
                viewModel.loadFields(true)
            }) {
                Text("Update list")
            }
        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            ShowProgress(viewModel.fieldsState.isLoading)
            FieldsList(viewModel.fieldsState.list)
            Error(viewModel.fieldsState.error)
        }
    }
}

@Composable
fun ShowProgress(progressState: Boolean) {
    if (progressState)
        CircularProgressIndicator()
}

@Composable
fun FieldsList(launchs: List<FieldNet>) {
    LazyColumn {
        items(items = launchs, itemContent = { item ->
            FieldItem(item, {

            })
        })
    }
}

@Composable
fun Error(error: String) {
    Text(modifier = Modifier.padding(16.dp), text = error)
}

@Composable
fun FieldItem(fieldNet: FieldNet, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(
                4.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .padding(8.dp)
                .background(MaterialTheme.colors.surface)
        ) {

            Column(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = fieldNet.name,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(fontSize = 16.sp),
                )
                CompositionLocalProvider(
                    LocalContentAlpha provides ContentAlpha.medium
                ) {
                    Text(
                        text = fieldNet.region,
                        style = typography.body2,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(end = 25.dp)
                    )
                }
            }
        }
    }
}