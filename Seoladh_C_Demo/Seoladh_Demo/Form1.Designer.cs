
namespace Seoladh
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.TbxTo = new System.Windows.Forms.TextBox();
            this.TbxCc = new System.Windows.Forms.TextBox();
            this.TbxtObjet = new System.Windows.Forms.TextBox();
            this.TbxEmail = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.RtbBody = new System.Windows.Forms.RichTextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.BtnAttachment = new System.Windows.Forms.Button();
            this.BtnEnvoyer = new System.Windows.Forms.Button();
            this.LbxAttachment = new System.Windows.Forms.ListBox();
            this.Ofd = new System.Windows.Forms.OpenFileDialog();
            this.TbxPassword = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // TbxTo
            // 
            this.TbxTo.Location = new System.Drawing.Point(135, 46);
            this.TbxTo.Name = "TbxTo";
            this.TbxTo.Size = new System.Drawing.Size(486, 23);
            this.TbxTo.TabIndex = 0;
            this.TbxTo.TextChanged += new System.EventHandler(this.TbxTo_TextChanged);
            // 
            // TbxCc
            // 
            this.TbxCc.Location = new System.Drawing.Point(135, 98);
            this.TbxCc.Name = "TbxCc";
            this.TbxCc.Size = new System.Drawing.Size(486, 23);
            this.TbxCc.TabIndex = 1;
            // 
            // TbxtObjet
            // 
            this.TbxtObjet.Location = new System.Drawing.Point(135, 152);
            this.TbxtObjet.Name = "TbxtObjet";
            this.TbxtObjet.Size = new System.Drawing.Size(486, 23);
            this.TbxtObjet.TabIndex = 2;
            // 
            // TbxEmail
            // 
            this.TbxEmail.Location = new System.Drawing.Point(185, 461);
            this.TbxEmail.Name = "TbxEmail";
            this.TbxEmail.Size = new System.Drawing.Size(146, 23);
            this.TbxEmail.TabIndex = 3;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(69, 46);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(15, 15);
            this.label1.TabIndex = 7;
            this.label1.Text = "À";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(69, 98);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(23, 15);
            this.label2.TabIndex = 8;
            this.label2.Text = "CC";
            this.label2.Click += new System.EventHandler(this.label2_Click_1);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(69, 152);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(36, 15);
            this.label3.TabIndex = 9;
            this.label3.Text = "Objet";
            this.label3.Click += new System.EventHandler(this.label3_Click);
            // 
            // RtbBody
            // 
            this.RtbBody.Location = new System.Drawing.Point(135, 191);
            this.RtbBody.Name = "RtbBody";
            this.RtbBody.Size = new System.Drawing.Size(486, 163);
            this.RtbBody.TabIndex = 10;
            this.RtbBody.Text = "";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(69, 204);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(53, 15);
            this.label4.TabIndex = 11;
            this.label4.Text = "Message";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(84, 422);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(54, 15);
            this.label5.TabIndex = 12;
            this.label5.Text = "Réglages";
            this.label5.Click += new System.EventHandler(this.label5_Click);
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(84, 464);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(47, 15);
            this.label6.TabIndex = 13;
            this.label6.Text = "E-mail :";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(84, 502);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(83, 15);
            this.label7.TabIndex = 14;
            this.label7.Text = "Mot de passe :";
            this.label7.Click += new System.EventHandler(this.label7_Click);
            // 
            // BtnAttachment
            // 
            this.BtnAttachment.Location = new System.Drawing.Point(611, 422);
            this.BtnAttachment.Name = "BtnAttachment";
            this.BtnAttachment.Size = new System.Drawing.Size(123, 23);
            this.BtnAttachment.TabIndex = 15;
            this.BtnAttachment.Text = "Joindre un fichier";
            this.BtnAttachment.UseVisualStyleBackColor = true;
            this.BtnAttachment.Click += new System.EventHandler(this.BtnAttachment_Click);
            // 
            // BtnEnvoyer
            // 
            this.BtnEnvoyer.Location = new System.Drawing.Point(611, 561);
            this.BtnEnvoyer.Name = "BtnEnvoyer";
            this.BtnEnvoyer.Size = new System.Drawing.Size(120, 23);
            this.BtnEnvoyer.TabIndex = 16;
            this.BtnEnvoyer.Text = "Envoyer";
            this.BtnEnvoyer.UseVisualStyleBackColor = true;
            this.BtnEnvoyer.Click += new System.EventHandler(this.BtnEnvoyer_Click);
            // 
            // LbxAttachment
            // 
            this.LbxAttachment.FormattingEnabled = true;
            this.LbxAttachment.ItemHeight = 15;
            this.LbxAttachment.Location = new System.Drawing.Point(611, 451);
            this.LbxAttachment.Name = "LbxAttachment";
            this.LbxAttachment.Size = new System.Drawing.Size(120, 94);
            this.LbxAttachment.TabIndex = 17;
            // 
            // TbxPassword
            // 
            this.TbxPassword.Location = new System.Drawing.Point(185, 499);
            this.TbxPassword.Name = "TbxPassword";
            this.TbxPassword.PasswordChar = '*';
            this.TbxPassword.Size = new System.Drawing.Size(146, 23);
            this.TbxPassword.TabIndex = 18;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 673);
            this.Controls.Add(this.TbxPassword);
            this.Controls.Add(this.LbxAttachment);
            this.Controls.Add(this.BtnEnvoyer);
            this.Controls.Add(this.BtnAttachment);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.RtbBody);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.TbxEmail);
            this.Controls.Add(this.TbxtObjet);
            this.Controls.Add(this.TbxCc);
            this.Controls.Add(this.TbxTo);
            this.Name = "Form1";
            this.Text = "Seoladh";
            this.Load += new System.EventHandler(this.Seoladh_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox TbxTo;
        private System.Windows.Forms.TextBox TbxCc;
        private System.Windows.Forms.TextBox TbxtObjet;
        private System.Windows.Forms.TextBox TbxEmail;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.RichTextBox RtbBody;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Button BtnAttachment;
        private System.Windows.Forms.Button BtnEnvoyer;
        private System.Windows.Forms.ListBox LbxAttachment;
        private System.Windows.Forms.TextBox TbxPassword;
        private System.Windows.Forms.OpenFileDialog Ofd;
        private System.Windows.Forms.TextBox textBox4;
    }
}

