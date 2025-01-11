package com.mehmetaliozek.sudokusolver.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.mehmetaliozek.sudokusolver.ui.theme.colors
import kotlinx.coroutines.launch

@Composable
fun Drawer(content: @Composable (changeDrawerValue: () -> Unit) -> Unit) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(drawerContainerColor = colors[2]) {
                // TODO: Geçmiş çözüm kaydını tut
                Text("Geçmiş çözümler")
                LazyColumn {
                    items(60) { i ->
                        Text("çözüm ${i + 1}")
                    }
                }
            }
        },
        content = {
            content {
                scope.launch {
                    if (drawerState.isClosed) {
                        drawerState.open()
                    } else {
                        drawerState.close()
                    }
                }
            }
        }
    )
}
