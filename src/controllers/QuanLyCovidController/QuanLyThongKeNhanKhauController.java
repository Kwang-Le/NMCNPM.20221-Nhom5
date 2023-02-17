package controllers.QuanLyCovidController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.NhanKhau;
import service.NhanKhauService;
import service.NhanKhauServiceImpl;
import utility.ClassTableModel;
import view.NhanKhauJFrame;
import java.lang.*;

/**
 *
 * @author admin
 */
public class QuanLyThongKeNhanKhauController {

    private JPanel jpnView;
    private JTextField jtfSearchGender;
    private JTextField jtfSearchAge1;
    private JTextField jtfSearchAge2;
    private NhanKhauService nhanKhauService = null;
    private String[] listColumn = {"ID", "Họ và Tên", "Ngày sinh", "Giới tính", "Nơi sinh", "Địa chỉ"};
    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyThongKeNhanKhauController(JPanel jpnView, JTextField jtfSearchGender, JTextField jtfSearchAge1, JTextField jtfSearchAge2) {
        this.jpnView = jpnView;
        this.jtfSearchGender = jtfSearchGender;
        this.jtfSearchAge1 = jtfSearchAge1;
        this.jtfSearchAge2 = jtfSearchAge2;
        this.nhanKhauService = new NhanKhauServiceImpl();
    }

    public void setDatetoTable() {
        List<NhanKhau> listItem = nhanKhauService.getList();
        DefaultTableModel model = new ClassTableModel().setTableNhanKhau(listItem, listColumn);
        JTable table = new JTable(model);
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        jtfSearchGender.getDocument().addDocumentListener(new DocumentListener() {
            List<RowFilter<Object, Object>> filters = new ArrayList<>(3);

            @Override
            public void insertUpdate(DocumentEvent e) {
                String textGender = jtfSearchGender.getText();
                Date startDate = new Date(Integer.parseInt(jtfSearchAge1.getText()), 1, 1);
                Date endDate = new Date(Integer.parseInt(jtfSearchAge2.getText()), 1, 1);
                if (textGender.trim().length() == 0) {
                    filters.add(RowFilter.dateFilter(ComparisonType.AFTER, startDate, 2));
                    filters.add(RowFilter.dateFilter(ComparisonType.BEFORE, endDate, 2));
                    rowSorter.setRowFilter(RowFilter.andFilter(filters));
                } else {
                    filters.add(RowFilter.regexFilter("(?i)" + textGender, 3));
                    filters.add(RowFilter.dateFilter(ComparisonType.AFTER, startDate, 2));
                    filters.add(RowFilter.dateFilter(ComparisonType.BEFORE, endDate, 2));
                    rowSorter.setRowFilter(RowFilter.andFilter(filters));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String textGender = jtfSearchGender.getText();
                Date startDate = new Date(Integer.parseInt(jtfSearchAge1.getText()), 1, 1);
                Date endDate = new Date(Integer.parseInt(jtfSearchAge2.getText()), 1, 1);
                if (textGender.trim().length() == 0) {
                    filters.add(RowFilter.dateFilter(ComparisonType.AFTER, startDate, 2));
                    filters.add(RowFilter.dateFilter(ComparisonType.BEFORE, endDate, 2));
                    rowSorter.setRowFilter(RowFilter.andFilter(filters));
                } else {
                    filters.add(RowFilter.regexFilter("(?i)" + textGender, 3));
                    filters.add(RowFilter.dateFilter(ComparisonType.AFTER, startDate, 2));
                    filters.add(RowFilter.dateFilter(ComparisonType.BEFORE, endDate, 2));
                    rowSorter.setRowFilter(RowFilter.andFilter(filters));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        
        jtfSearchAge1.getDocument().addDocumentListener(new DocumentListener() {
            List<RowFilter<Object, Object>> filters = new ArrayList<>(3);

            @Override
            public void insertUpdate(DocumentEvent e) {
                String textGender = jtfSearchGender.getText();
                Date startDate = new Date(Integer.parseInt(jtfSearchAge1.getText()), 1, 1);
                Date endDate = new Date(Integer.parseInt(jtfSearchAge2.getText()), 1, 1);
                if (jtfSearchAge1.getText().trim().length() == 0) {
                    filters.add(RowFilter.regexFilter("(?i)" + textGender, 3));
                    filters.add(RowFilter.dateFilter(ComparisonType.BEFORE, endDate, 2));
                    rowSorter.setRowFilter(RowFilter.andFilter(filters));
                } else {
                    filters.add(RowFilter.regexFilter("(?i)" + textGender, 3));
                    filters.add(RowFilter.dateFilter(ComparisonType.AFTER, startDate, 2));
                    filters.add(RowFilter.dateFilter(ComparisonType.BEFORE, endDate, 2));
                    rowSorter.setRowFilter(RowFilter.andFilter(filters));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String textGender = jtfSearchGender.getText();
                Date startDate = new Date(Integer.parseInt(jtfSearchAge1.getText()), 1, 1);
                Date endDate = new Date(Integer.parseInt(jtfSearchAge2.getText()), 1, 1);
                if (jtfSearchAge1.getText().trim().length() == 0) {
                    filters.add(RowFilter.regexFilter("(?i)" + textGender, 3));
                    filters.add(RowFilter.dateFilter(ComparisonType.BEFORE, endDate, 2));
                    rowSorter.setRowFilter(RowFilter.andFilter(filters));
                } else {
                    filters.add(RowFilter.regexFilter("(?i)" + textGender, 3));
                    filters.add(RowFilter.dateFilter(ComparisonType.AFTER, startDate, 2));
                    filters.add(RowFilter.dateFilter(ComparisonType.BEFORE, endDate, 2));
                    rowSorter.setRowFilter(RowFilter.andFilter(filters));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        
        jtfSearchAge2.getDocument().addDocumentListener(new DocumentListener() {
            List<RowFilter<Object, Object>> filters = new ArrayList<>(3);

            @Override
            public void insertUpdate(DocumentEvent e) {
                String textGender = jtfSearchGender.getText();
                Date startDate = new Date(Integer.parseInt(jtfSearchAge1.getText()), 1, 1);
                Date endDate = new Date(Integer.parseInt(jtfSearchAge2.getText()), 1, 1);
                if (jtfSearchAge2.getText().trim().length() == 0) {
                    filters.add(RowFilter.regexFilter("(?i)" + textGender, 3));
                    filters.add(RowFilter.dateFilter(ComparisonType.AFTER, startDate, 2));
                    rowSorter.setRowFilter(RowFilter.andFilter(filters));
                } else {
                    filters.add(RowFilter.regexFilter("(?i)" + textGender, 3));
                    filters.add(RowFilter.dateFilter(ComparisonType.AFTER, startDate, 2));
                    filters.add(RowFilter.dateFilter(ComparisonType.BEFORE, endDate, 2));
                    rowSorter.setRowFilter(RowFilter.andFilter(filters));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String textGender = jtfSearchGender.getText();
                Date startDate = new Date(Integer.parseInt(jtfSearchAge1.getText()), 1, 1);
                Date endDate = new Date(Integer.parseInt(jtfSearchAge2.getText()), 1, 1);
                if (jtfSearchAge2.getText().trim().length() == 0) {
                    filters.add(RowFilter.regexFilter("(?i)" + textGender, 3));
                    filters.add(RowFilter.dateFilter(ComparisonType.AFTER, startDate, 2));
                    rowSorter.setRowFilter(RowFilter.andFilter(filters));
                } else {
                    filters.add(RowFilter.regexFilter("(?i)" + textGender, 3));
                    filters.add(RowFilter.dateFilter(ComparisonType.AFTER, startDate, 2));
                    filters.add(RowFilter.dateFilter(ComparisonType.BEFORE, endDate, 2));
                    rowSorter.setRowFilter(RowFilter.andFilter(filters));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        table.getColumnModel().getColumn(2).setMaxWidth(80);
        table.getColumnModel().getColumn(2).setMinWidth(80);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    NhanKhau nhanKhau = new NhanKhau();
                    nhanKhau.setID((int) model.getValueAt(selectedRowIndex, 0));
                    nhanKhau.setHoTen(model.getValueAt(selectedRowIndex, 1).toString());
                    nhanKhau.setNgaySinh((Date) model.getValueAt(selectedRowIndex, 2));
                    nhanKhau.setGioiTinh(model.getValueAt(selectedRowIndex, 3).toString());
                    nhanKhau.setNoiSinh((String) model.getValueAt(selectedRowIndex, 4));
                    nhanKhau.setDiaChi((String) model.getValueAt(selectedRowIndex, 5));

                    NhanKhauJFrame frame = new NhanKhauJFrame(nhanKhau);
                    frame.setTitle("Thông Tin Nhân Khẩu");
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }

            }

        });

        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setPreferredSize(new Dimension(1350, 400));
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane);
        jpnView.validate();
        jpnView.repaint();
    }

}
