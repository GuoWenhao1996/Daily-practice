namespace jisuanqi
{
    partial class Form1
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要修改
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            this.button1 = new System.Windows.Forms.Button();
            this.num_in = new System.Windows.Forms.TextBox();
            this.num_out = new System.Windows.Forms.TextBox();
            this.num1 = new System.Windows.Forms.TextBox();
            this.num2 = new System.Windows.Forms.TextBox();
            this.button2 = new System.Windows.Forms.Button();
            this.result = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(289, 192);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 0;
            this.button1.Text = "计算";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // num_in
            // 
            this.num_in.Location = new System.Drawing.Point(163, 194);
            this.num_in.Name = "num_in";
            this.num_in.Size = new System.Drawing.Size(100, 21);
            this.num_in.TabIndex = 1;
            // 
            // num_out
            // 
            this.num_out.Font = new System.Drawing.Font("宋体", 16F);
            this.num_out.Location = new System.Drawing.Point(387, 194);
            this.num_out.Name = "num_out";
            this.num_out.Size = new System.Drawing.Size(386, 32);
            this.num_out.TabIndex = 2;
            // 
            // num1
            // 
            this.num1.Location = new System.Drawing.Point(141, 51);
            this.num1.Name = "num1";
            this.num1.Size = new System.Drawing.Size(100, 21);
            this.num1.TabIndex = 3;
            // 
            // num2
            // 
            this.num2.Location = new System.Drawing.Point(279, 51);
            this.num2.Name = "num2";
            this.num2.Size = new System.Drawing.Size(100, 21);
            this.num2.TabIndex = 4;
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(430, 48);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(75, 23);
            this.button2.TabIndex = 5;
            this.button2.Text = "计算";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // result
            // 
            this.result.Font = new System.Drawing.Font("宋体", 16F);
            this.result.Location = new System.Drawing.Point(538, 50);
            this.result.Name = "result";
            this.result.Size = new System.Drawing.Size(235, 32);
            this.result.TabIndex = 6;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(799, 304);
            this.Controls.Add(this.result);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.num2);
            this.Controls.Add(this.num1);
            this.Controls.Add(this.num_out);
            this.Controls.Add(this.num_in);
            this.Controls.Add(this.button1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.TextBox num_in;
        private System.Windows.Forms.TextBox num_out;
        private System.Windows.Forms.TextBox num1;
        private System.Windows.Forms.TextBox num2;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.TextBox result;
    }
}

