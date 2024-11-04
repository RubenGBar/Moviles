package com.example.conexiones2

import android.bluetooth.BluetoothManager
import android.content.Context
import android.location.LocationManager
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.nfc.NfcManager
import androidx.compose.foundation.background
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

@Composable
fun compruebaConexion() {
    val context: Context = LocalContext.current.applicationContext
    val wifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
    val bluetoothManager = context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
    val nfcManager = context.getSystemService(Context.NFC_SERVICE) as NfcManager
    val gpsManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val isWifiEnabled = wifiManager.isWifiEnabled
    val bluetoothAdapter = bluetoothManager.adapter
    val nfcAdapter = nfcManager.defaultAdapter
    val isGpsEnabled = gpsManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    val isConnectivity = connectivityManager.isActiveNetworkMetered

    var WifiColor = Color.Red
    var BluetoothColor = Color.Red
    var NFCColor = Color.Red
    var GPSColor = Color.Red
    var DatosColor = Color.Red
    if(isWifiEnabled)
        WifiColor = Color.Green
    if(bluetoothAdapter.isEnabled)
        BluetoothColor = Color.Green
    if(nfcAdapter != null && nfcAdapter.isEnabled)
        NFCColor = Color.Green
    if(isGpsEnabled)
        GPSColor = Color.Green
    if(isConnectivity)
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
            Text("WIFI", Modifier.background(color = WifiColor))
        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            Text("Bluetooth", Modifier.background(color = BluetoothColor))
        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            Text("NFC", Modifier.background(color = NFCColor))
        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            Text("GPS", Modifier.background(color = GPSColor))
        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            Text("Color", Modifier.background(color = DatosColor))
        }

    }

}