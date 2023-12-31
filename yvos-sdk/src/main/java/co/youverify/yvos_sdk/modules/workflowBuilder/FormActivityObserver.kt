package co.youverify.yvos_sdk.modules.workflowBuilder

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

internal class FormActivityObserver(val workflowBuilderModule: WorkflowBuilderModule):DefaultLifecycleObserver {

    //private var onResumeCalled=false

     var onSuccessCallback:(String)->Unit={}
     var onFailedCallback:()->Unit={}
    var onCompletedCallback:(String)->Unit={}
    //lateinit var option:VFormOption
    lateinit var formActivity:FormActivity


    override fun onCreate(owner: LifecycleOwner) {
        formActivity=owner as FormActivity

    }

    override fun onStart(owner: LifecycleOwner) {

        onSuccessCallback=workflowBuilderModule.onSuccess
        onFailedCallback=workflowBuilderModule.onFailed
        onCompletedCallback=workflowBuilderModule.onCompleted


        formActivity.apply {
            onSuccess=onSuccessCallback
            onFailed=onFailedCallback
            onCompleted=onCompletedCallback
        }
    }

    override fun onResume(owner: LifecycleOwner) {

        //send liveness data only if onResume is being called for the first time and camera permission has been granted
        //and sendFormUrl() has not been called
        /*if (!onResumeCalled && formActivity.cameraPermissionGranted && !formActivity.urlIsLoading){
            onResumeCalled=true
            formActivity.lifecycleScope.launch { vFormModule.sendFormUrl() }

        }*/
    }

    fun sendFormUrl(){
        formActivity.lifecycleScope.launch { workflowBuilderModule.sendFormUrl() }
    }
}