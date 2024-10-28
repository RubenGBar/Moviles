package com.example.comprobacionconexion

import android.bluetooth.BluetoothManager
import android.content.Context
import android.location.LocationManager
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.nfc.NfcManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            conexiones()
        }
    }
}

@Composable
fun conexiones() {
    val context: Context = LocalContext.current.applicationContext
    val WifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
    val BluetoothManager = context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
    val NFCManager = context.getSystemService(Context.NFC_SERVICE) as NfcManager
    val GPSManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    val ConexionManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val nfcAdapter = NFCManager.defaultAdapter
    val bluetoothAdapter = BluetoothManager.adapter
    val isGpsEnabled = GPSManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    var WifiColor = Color.Red
    var BluetoothColor = Color.Red
    var NFCColor = Color.Red
    var GPSColor = Color.Red
    var DatosColor = Color.Red
    if(WifiManager.isWifiEnabled)
        WifiColor = Color.Green
    if(bluetoothAdapter.isEnabled)
        BluetoothColor = Color.Green
    if(nfcAdapter != null && nfcAdapter.isEnabled)
        NFCColor = Color.Green
    if(isGpsEnabled)
        GPSColor = Color.Green
    if(ConexionManager.isActiveNetworkMetered)
        DatosColor = Color.Green

    Column (

        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            Text("WIFI", color = WifiColor)
        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            Text("Bluetooth", color = BluetoothColor)
        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            Text("NFC", color = NFCColor)
        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            Text("GPS", color = GPSColor)
        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            Text("Color", color = DatosColor)
        }

    }

}