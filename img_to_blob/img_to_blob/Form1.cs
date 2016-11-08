using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace img_to_blob
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string path = this.textBox1.Text;
            byte[] imgBytesIn = SaveImage(path);
            ShowImgByByte(imgBytesIn);
            //Parameters.Add("@Photo", SqlDbType.Binary).Value = imgBytesIn;

        }
        //将图片以二进制流
        public byte[] SaveImage(String path)
        {
            FileStream fs = new FileStream(path, FileMode.Open, FileAccess.Read); //将图片以文件流的形式进行保存
            BinaryReader br = new BinaryReader(fs);
            byte[] imgBytesIn = br.ReadBytes((int)fs.Length);  //将流读入到字节数组中
            string s = "";
            for (int i = 0; i < imgBytesIn.Length; i++) { 
             s = s + imgBytesIn[i];
            }
            textBox2.Text = s;
            textBox3.Text = imgBytesIn.Length.ToString();
            return imgBytesIn;
        }
        //现实二进制流代表的图片
        public void ShowImgByByte(byte[] imgBytesIn)
        {
            MemoryStream ms = new MemoryStream(imgBytesIn);
            pictureBox1.Image = Image.FromStream(ms);
        }
    }
}
