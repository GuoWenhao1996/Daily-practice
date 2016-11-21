using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace jisuanqi
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            double a = double.Parse(num1.Text);
            double b = double.Parse(num2.Text);
            double c = (a + b) / 2;
            result.Text = c.ToString();
            num_in.Text = c.ToString();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            double x = double.Parse(num_in.Text);
            //double y = x * x * x - x - 1;
            double y = (x + 7 / x) * 0.5;
            num_out.Text = y.ToString();
        }
    }
}
