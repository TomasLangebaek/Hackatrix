var environments = {
  staging: {
    FIREBASE_API_KEY: 'AIzaSyCAMlnveZiOhX4KuolfVq_0DRFOvOPKGQw',
    FIREBASE_AUTH_DOMAIN: 'trash-recognition-1b478.firebaseapp.com',
    FIREBASE_DATABASE_URL: 'https://trash-recognition-1b478.firebaseio.com',
    FIREBASE_PROJECT_ID: 'trash-recognition-1b478',
    FIREBASE_STORAGE_BUCKET: 'trash-recognition-1b478.appspot.com',
    FIREBASE_MESSAGING_SENDER_ID: '798764358331',
    GOOGLE_CLOUD_VISION_API_KEY: 'XXXX'
  },
  production: {
    // Warning: This file still gets included in your native binary and is not a secure way to store secrets if you build for the app stores. Details: https://github.com/expo/expo/issues/83
  }
};

function getReleaseChannel() {
  let releaseChannel = Expo.Constants.manifest.releaseChannel;
  if (releaseChannel === undefined) {
    return 'staging';
  } else if (releaseChannel === 'staging') {
    return 'staging';
  } else {
    return 'staging';
  }
}
function getEnvironment(env) {
  console.log('Release Channel: ', getReleaseChannel());
  return environments[env];
}
var Environment = getEnvironment(getReleaseChannel());
export default Environment;

