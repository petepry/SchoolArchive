using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ProjectAPBD_1._2._1a
{
    public partial class MainWindow : Form
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void button_candidates_Click(object sender, EventArgs e)
        {
            Candidates window = new Candidates();
            window.Show();
        }

        private void button_close_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void button_offers_Click(object sender, EventArgs e)
        {
            Offers windowOffers = new Offers();
            windowOffers.Show();
        }
    }
}
