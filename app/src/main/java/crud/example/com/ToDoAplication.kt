package crud.example.com

import android.app.Application
import crud.example.com.di.appModule
import crud.example.com.di.storageModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class ToDoApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ToDoApplication)
            modules(
                appModule,
                storageModule
            )
        }
    }
}