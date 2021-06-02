using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Net.Mail;
using System.Net;
using System.Net.Mime;


namespace Seoladh
{
    public partial class Form1 : Form
    {

        MailMessage msg;
        List<Attachment> attachments;
        public Form1()
        {
            InitializeComponent();
            attachments = new List<Attachment>();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click_1(object sender, EventArgs e)
        {

        }

        private void label7_Click(object sender, EventArgs e)
        {

        }

        private void label5_Click(object sender, EventArgs e)
        {

        }



        

        private void BtnEnvoyer_Click(object sender, EventArgs e)
        {
            SmtpClient client = new SmtpClient();
            client.Port = 587;
            client.Host = "smtp.gmail.com ";
            client.EnableSsl = true;
            client.Timeout = 10000;
            client.DeliveryMethod = SmtpDeliveryMethod.Network;
            client.UseDefaultCredentials = false;
            client.Credentials = new NetworkCredential(TbxEmail.Text, TbxPassword.Text);
            msg = new MailMessage(TbxEmail.Text, TbxTo.Text, TbxtObjet.Text, RtbBody.Text);
            foreach (Attachment attach in attachments)
            {
                msg.Attachments.Add(attach);
            }

            if (!string.IsNullOrEmpty(TbxCc.Text))
            {
                msg.To.Add(new MailAddress(TbxCc.Text));
            }
            msg.Priority = MailPriority.Normal;
            msg.BodyEncoding = Encoding.UTF8;
            msg.DeliveryNotificationOptions = DeliveryNotificationOptions.OnFailure;
            client.Send(msg);
        }

        private void TbxTo_TextChanged(object sender, EventArgs e)
        {

        }

        private void BtnAttachment_Click(object sender, EventArgs e)
        {
            DialogResult dr = Ofd.ShowDialog();
            if (dr == DialogResult.OK)
            {
                attachments.Add(new Attachment(Ofd.FileName, MediaTypeNames.Application.Octet));
                LbxAttachment.Items.Add(Ofd.SafeFileName);
            }
        }

        private void Seoladh_Load(object sender, EventArgs e)
        {

        }
    }
}
