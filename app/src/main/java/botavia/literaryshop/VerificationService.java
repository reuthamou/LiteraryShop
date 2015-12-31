package botavia.literaryshop;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;
import model.datasource.DatabaseList;
import entities.Customer;

public class VerificationService extends Service {
    public VerificationService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");

        databaseList().findCustomerByUsername(username);

        return 0;
    }
}
