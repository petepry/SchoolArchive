namespace ProjectAPBD_1._2._1a
{
    partial class Candidates
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
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
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.button_updateDB = new System.Windows.Forms.Button();
            this.buttonRefresh = new System.Windows.Forms.Button();
            this.kANDselectBindingSource1 = new System.Windows.Forms.BindingSource(this.components);
            this.button1 = new System.Windows.Forms.Button();
            this.kANDselectBindingSource3 = new System.Windows.Forms.BindingSource(this.components);
            this.dataSet1 = new ProjectAPBD_1._2._1a.DataSet1();
            this.kANDselectBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.dataSet1BindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.kAND_selectTableAdapter = new ProjectAPBD_1._2._1a.DataSet1TableAdapters.KAND_selectTableAdapter();
            this.kANDselectBindingSource2 = new System.Windows.Forms.BindingSource(this.components);
            this.jEZYKOBCYBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.jEZYKOBCYTableAdapter = new ProjectAPBD_1._2._1a.DataSet1TableAdapters.JEZYKOBCYTableAdapter();
            this.idKandydatDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.idzawodDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.idjezykobcyDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.imieDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.nazwiskoDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataurodzeniaDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataOtwarciaDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataZamknieciaDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.zawodDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.stazPracyDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.jezykDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewComboBoxColumn();
            this.poziomDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.inneDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.kANDselectBindingSource1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.kANDselectBindingSource3)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataSet1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.kANDselectBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataSet1BindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.kANDselectBindingSource2)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.jEZYKOBCYBindingSource)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGridView1
            // 
            this.dataGridView1.AutoGenerateColumns = false;
            this.dataGridView1.CausesValidation = false;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.idKandydatDataGridViewTextBoxColumn,
            this.idzawodDataGridViewTextBoxColumn,
            this.idjezykobcyDataGridViewTextBoxColumn,
            this.imieDataGridViewTextBoxColumn,
            this.nazwiskoDataGridViewTextBoxColumn,
            this.dataurodzeniaDataGridViewTextBoxColumn,
            this.dataOtwarciaDataGridViewTextBoxColumn,
            this.dataZamknieciaDataGridViewTextBoxColumn,
            this.zawodDataGridViewTextBoxColumn,
            this.stazPracyDataGridViewTextBoxColumn,
            this.jezykDataGridViewTextBoxColumn,
            this.poziomDataGridViewTextBoxColumn,
            this.inneDataGridViewTextBoxColumn});
            this.dataGridView1.DataSource = this.kANDselectBindingSource;
            this.dataGridView1.Dock = System.Windows.Forms.DockStyle.Top;
            this.dataGridView1.Location = new System.Drawing.Point(0, 0);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.Size = new System.Drawing.Size(1096, 255);
            this.dataGridView1.TabIndex = 0;
            // 
            // button_updateDB
            // 
            this.button_updateDB.Location = new System.Drawing.Point(12, 275);
            this.button_updateDB.Name = "button_updateDB";
            this.button_updateDB.Size = new System.Drawing.Size(79, 40);
            this.button_updateDB.TabIndex = 1;
            this.button_updateDB.Text = "Zapisz zmiany";
            this.button_updateDB.UseVisualStyleBackColor = true;
            this.button_updateDB.Click += new System.EventHandler(this.button_updateDB_Click);
            // 
            // buttonRefresh
            // 
            this.buttonRefresh.Location = new System.Drawing.Point(106, 275);
            this.buttonRefresh.Name = "buttonRefresh";
            this.buttonRefresh.Size = new System.Drawing.Size(74, 40);
            this.buttonRefresh.TabIndex = 2;
            this.buttonRefresh.Text = "Odśwież";
            this.buttonRefresh.UseVisualStyleBackColor = true;
            this.buttonRefresh.Click += new System.EventHandler(this.button1_Click);
            // 
            // kANDselectBindingSource1
            // 
            this.kANDselectBindingSource1.DataMember = "KAND_select";
            this.kANDselectBindingSource1.DataSource = this.dataSet1BindingSource;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(255, 275);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 40);
            this.button1.TabIndex = 3;
            this.button1.Text = "Zamknij";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click_1);
            // 
            // kANDselectBindingSource3
            // 
            this.kANDselectBindingSource3.DataMember = "KAND_select";
            this.kANDselectBindingSource3.DataSource = this.dataSet1;
            // 
            // dataSet1
            // 
            this.dataSet1.DataSetName = "DataSet1";
            this.dataSet1.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // kANDselectBindingSource
            // 
            this.kANDselectBindingSource.DataMember = "KAND_select";
            this.kANDselectBindingSource.DataSource = this.dataSet1;
            // 
            // dataSet1BindingSource
            // 
            this.dataSet1BindingSource.DataSource = this.dataSet1;
            this.dataSet1BindingSource.Position = 0;
            // 
            // kAND_selectTableAdapter
            // 
            this.kAND_selectTableAdapter.ClearBeforeFill = true;
            // 
            // kANDselectBindingSource2
            // 
            this.kANDselectBindingSource2.DataMember = "KAND_select";
            this.kANDselectBindingSource2.DataSource = this.dataSet1;
            // 
            // jEZYKOBCYBindingSource
            // 
            this.jEZYKOBCYBindingSource.DataMember = "JEZYKOBCY";
            this.jEZYKOBCYBindingSource.DataSource = this.dataSet1;
            // 
            // jEZYKOBCYTableAdapter
            // 
            this.jEZYKOBCYTableAdapter.ClearBeforeFill = true;
            // 
            // idKandydatDataGridViewTextBoxColumn
            // 
            this.idKandydatDataGridViewTextBoxColumn.DataPropertyName = "idKandydat";
            this.idKandydatDataGridViewTextBoxColumn.HeaderText = "idKandydat";
            this.idKandydatDataGridViewTextBoxColumn.Name = "idKandydatDataGridViewTextBoxColumn";
            this.idKandydatDataGridViewTextBoxColumn.ReadOnly = true;
            this.idKandydatDataGridViewTextBoxColumn.Visible = false;
            // 
            // idzawodDataGridViewTextBoxColumn
            // 
            this.idzawodDataGridViewTextBoxColumn.DataPropertyName = "idzawod";
            this.idzawodDataGridViewTextBoxColumn.HeaderText = "idzawod";
            this.idzawodDataGridViewTextBoxColumn.Name = "idzawodDataGridViewTextBoxColumn";
            this.idzawodDataGridViewTextBoxColumn.ReadOnly = true;
            this.idzawodDataGridViewTextBoxColumn.Visible = false;
            // 
            // idjezykobcyDataGridViewTextBoxColumn
            // 
            this.idjezykobcyDataGridViewTextBoxColumn.DataPropertyName = "idjezykobcy";
            this.idjezykobcyDataGridViewTextBoxColumn.HeaderText = "idjezykobcy";
            this.idjezykobcyDataGridViewTextBoxColumn.Name = "idjezykobcyDataGridViewTextBoxColumn";
            this.idjezykobcyDataGridViewTextBoxColumn.ReadOnly = true;
            this.idjezykobcyDataGridViewTextBoxColumn.Resizable = System.Windows.Forms.DataGridViewTriState.True;
            this.idjezykobcyDataGridViewTextBoxColumn.Visible = false;
            // 
            // imieDataGridViewTextBoxColumn
            // 
            this.imieDataGridViewTextBoxColumn.DataPropertyName = "imie";
            this.imieDataGridViewTextBoxColumn.HeaderText = "Imię";
            this.imieDataGridViewTextBoxColumn.Name = "imieDataGridViewTextBoxColumn";
            // 
            // nazwiskoDataGridViewTextBoxColumn
            // 
            this.nazwiskoDataGridViewTextBoxColumn.DataPropertyName = "nazwisko";
            this.nazwiskoDataGridViewTextBoxColumn.HeaderText = "Nazwisko";
            this.nazwiskoDataGridViewTextBoxColumn.Name = "nazwiskoDataGridViewTextBoxColumn";
            // 
            // dataurodzeniaDataGridViewTextBoxColumn
            // 
            this.dataurodzeniaDataGridViewTextBoxColumn.DataPropertyName = "dataurodzenia";
            this.dataurodzeniaDataGridViewTextBoxColumn.HeaderText = "Data urodzenia";
            this.dataurodzeniaDataGridViewTextBoxColumn.Name = "dataurodzeniaDataGridViewTextBoxColumn";
            // 
            // dataOtwarciaDataGridViewTextBoxColumn
            // 
            this.dataOtwarciaDataGridViewTextBoxColumn.DataPropertyName = "DataOtwarcia";
            this.dataOtwarciaDataGridViewTextBoxColumn.HeaderText = "Dostępny od";
            this.dataOtwarciaDataGridViewTextBoxColumn.Name = "dataOtwarciaDataGridViewTextBoxColumn";
            // 
            // dataZamknieciaDataGridViewTextBoxColumn
            // 
            this.dataZamknieciaDataGridViewTextBoxColumn.DataPropertyName = "DataZamkniecia";
            this.dataZamknieciaDataGridViewTextBoxColumn.HeaderText = "Znalazł pracę";
            this.dataZamknieciaDataGridViewTextBoxColumn.Name = "dataZamknieciaDataGridViewTextBoxColumn";
            // 
            // zawodDataGridViewTextBoxColumn
            // 
            this.zawodDataGridViewTextBoxColumn.DataPropertyName = "zawod";
            this.zawodDataGridViewTextBoxColumn.HeaderText = "Zawód";
            this.zawodDataGridViewTextBoxColumn.Name = "zawodDataGridViewTextBoxColumn";
            // 
            // stazPracyDataGridViewTextBoxColumn
            // 
            this.stazPracyDataGridViewTextBoxColumn.DataPropertyName = "StazPracy";
            this.stazPracyDataGridViewTextBoxColumn.HeaderText = "Staż pracy";
            this.stazPracyDataGridViewTextBoxColumn.Name = "stazPracyDataGridViewTextBoxColumn";
            // 
            // jezykDataGridViewTextBoxColumn
            // 
            this.jezykDataGridViewTextBoxColumn.DataPropertyName = "jezyk";
            this.jezykDataGridViewTextBoxColumn.DataSource = this.jEZYKOBCYBindingSource;
            this.jezykDataGridViewTextBoxColumn.DisplayMember = "jezyk";
            this.jezykDataGridViewTextBoxColumn.HeaderText = "Język obcy";
            this.jezykDataGridViewTextBoxColumn.Name = "jezykDataGridViewTextBoxColumn";
            this.jezykDataGridViewTextBoxColumn.Resizable = System.Windows.Forms.DataGridViewTriState.True;
            this.jezykDataGridViewTextBoxColumn.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.Automatic;
            this.jezykDataGridViewTextBoxColumn.ValueMember = "jezyk";
            // 
            // poziomDataGridViewTextBoxColumn
            // 
            this.poziomDataGridViewTextBoxColumn.DataPropertyName = "poziom";
            this.poziomDataGridViewTextBoxColumn.HeaderText = "Poziom";
            this.poziomDataGridViewTextBoxColumn.Name = "poziomDataGridViewTextBoxColumn";
            // 
            // inneDataGridViewTextBoxColumn
            // 
            this.inneDataGridViewTextBoxColumn.DataPropertyName = "inne";
            this.inneDataGridViewTextBoxColumn.HeaderText = "Inne";
            this.inneDataGridViewTextBoxColumn.Name = "inneDataGridViewTextBoxColumn";
            // 
            // Candidates
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1096, 327);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.buttonRefresh);
            this.Controls.Add(this.button_updateDB);
            this.Controls.Add(this.dataGridView1);
            this.Name = "Candidates";
            this.Text = "Kandydaci";
            this.Load += new System.EventHandler(this.Candidates_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.kANDselectBindingSource1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.kANDselectBindingSource3)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataSet1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.kANDselectBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataSet1BindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.kANDselectBindingSource2)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.jEZYKOBCYBindingSource)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.BindingSource dataSet1BindingSource;
        private DataSet1 dataSet1;
        private System.Windows.Forms.BindingSource kANDselectBindingSource;
        private DataSet1TableAdapters.KAND_selectTableAdapter kAND_selectTableAdapter;
        private System.Windows.Forms.Button button_updateDB;
        private System.Windows.Forms.Button buttonRefresh;
        private System.Windows.Forms.BindingSource kANDselectBindingSource2;
        private System.Windows.Forms.BindingSource kANDselectBindingSource1;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.BindingSource kANDselectBindingSource3;
        private System.Windows.Forms.BindingSource jEZYKOBCYBindingSource;
        private DataSet1TableAdapters.JEZYKOBCYTableAdapter jEZYKOBCYTableAdapter;
        private System.Windows.Forms.DataGridViewTextBoxColumn idKandydatDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn idzawodDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn idjezykobcyDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn imieDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn nazwiskoDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataurodzeniaDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataOtwarciaDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataZamknieciaDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn zawodDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn stazPracyDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewComboBoxColumn jezykDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn poziomDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn inneDataGridViewTextBoxColumn;
    }
}