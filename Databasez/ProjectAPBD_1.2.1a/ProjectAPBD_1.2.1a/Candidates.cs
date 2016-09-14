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
    public partial class Candidates : Form
    {

        private BindingSource bindingSource1 = new BindingSource();
        public Candidates()
        {
            InitializeComponent();
        }

        private void Candidates_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'dataSet1.JEZYKOBCY' table. You can move, or remove it, as needed.
            this.jEZYKOBCYTableAdapter.Fill(this.dataSet1.JEZYKOBCY);
            // TODO: This line of code loads data into the 'dataSet1.KAND_select' table. You can move, or remove it, as needed.
            this.kAND_selectTableAdapter.Fill(this.dataSet1.KAND_select);

        }

        private void button_updateDB_Click(object sender, EventArgs e)
        {
            try
            {
                this.kAND_selectTableAdapter.Update(this.dataSet1.KAND_select);
            }
            catch (Exception ex)
            {
                MessageBox.Show("Wystąpił (jeszcze) nieznany błąd... \n" + ex.Data.ToString());
            }
            
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.kAND_selectTableAdapter.Fill(this.dataSet1.KAND_select);
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
