package com.bignerdranch.android.criminalintent
import android.app.AlertDialog
import android.app.Dialog
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
class ZoomedImageDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.fragment_zoomed_image_dialog, null)

        // 获取图片的 URI 或路径
        val imageUri: Uri? = arguments?.getParcelable(ARG_IMAGE_URI)

        // 在 ImageView 中显示图片
        val imageView = view.findViewById<ImageView>(R.id.zoomedImageView)
        imageView.setImageURI(imageUri)

        builder.setView(view)
            .setPositiveButton("Close") { dialog, _ ->
                dialog.dismiss()
            }

        return builder.create()
    }

    companion object {
        private const val ARG_IMAGE_URI = "image_uri"

        // 创建实例并传入图片 URI
        fun newInstance(imageUri: Uri): ZoomedImageDialogFragment {
            val fragment = ZoomedImageDialogFragment()
            val args = Bundle()
            args.putParcelable(ARG_IMAGE_URI, imageUri)
            fragment.arguments = args
            return fragment
        }
    }
}
