# SmsReceiver

#### 필요 권한
````xml
<uses-permission android:name="android.permission.READ_SMS"/>
<uses-permission android:name="android.permission.RECEIVE_SMS"/>
````

#### SmsReceiver

* BroadcastReceiver를 상속하여 SmsRecevier 클래스를 구현한다.
* 필수로 Override 해야 되는 함수가 onReceive 함수이며, 함수의 intent 인자를 통해서 SMS 메세지를 필터링 할 수 있다.

````java
public void onReceive(Context context, Intent intent) {
    if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
        Bundle bundle = intent.getExtras();
        Object objs[] = (Object[]) bundle.get("pdus");
        SmsMessage smss[] = new SmsMessage[objs.length];
        for (int i = 0; i < smss.length; ++i) {
            smss[i] = SmsMessage.createFromPdu((byte[]) objs[i]);
            System.out.println("spdn " + i + " SMS: " + smss[i].getDisplayMessageBody());
        }
    }
}
````

