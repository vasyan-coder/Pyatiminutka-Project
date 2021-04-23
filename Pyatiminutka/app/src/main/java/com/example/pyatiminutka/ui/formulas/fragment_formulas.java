package com.example.pyatiminutka.ui.formulas;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.pyatiminutka.Models.Adapters.FormulasMainAdapter;
import com.example.pyatiminutka.Models.DataBase.QuestionTest;
import com.example.pyatiminutka.Models.items.formulasItem;
import com.example.pyatiminutka.R;

import java.util.ArrayList;
import java.util.List;

public class fragment_formulas extends Fragment {

    private RecyclerView recycler_formulas;

    private List<formulasItem> mTitleTheme = new ArrayList<>();
    private List<formulasItem> mFormulas;

    private FormulasMainAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_formulas, container, false);

        recycler_formulas = root.findViewById(R.id.recycler_formulas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recycler_formulas.setLayoutManager(layoutManager);

        listAdd();

        adapter = new FormulasMainAdapter(mTitleTheme, getContext());
        recycler_formulas.setAdapter(adapter);

        EditText editText = root.findViewById(R.id.searchFormulasFilter);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        return root;
    }

    private void filter(String text) {
        ArrayList<formulasItem> filteredList = new ArrayList<>();


        for (formulasItem item : mTitleTheme) {
            if (item.getTag().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
//            else if (item.getText_formulas().toLowerCase().contains(text.toLowerCase())) {
//                filteredList.add(item);
//            }
        }
        adapter.filterFormulasList(filteredList);
    }

    private void listAdd() {

        String p1_r1_n1 =  "s=x-x0  проекция перемещения на ось X ";
        String p1_r1_n2 =  "V=S/t  скорость равномерного прямолинейного движения ";
        String p1_r1_n3 =  "Vcp=S/t средняя скорость ";
        String p1_r1_n4 =  "x=x0+vt уравнение равномерного прямолинейного движения ";
        String p1_r1_n5 =  "a=v-vo/t ускорение при равноускоренном движении ";
        String p1_r1_n6 =  "v=v0+at скорость при равноускоренном движении ";
        String p1_r1_n7 =  "S=(v+v0/2)t перемещение при равноускоренном движении ";
        String p1_r1_n8 =  "S=v0t+at^2/2 зависимость перемещения при равноускоренном движении от времени ";
        String p1_r1_n9 =  "sx=v^2-v0^2/2a проекция перемещения при равноускоренном движении без времени ";
        String p1_r1_n10 =  "x=x0+v0t+at^2/2 уравнение раввноускоренного движения ";

        String p1_r2_n1 =  "v=N/t частота обращения ";
        String p1_r2_n2 =  "T=t/N период обращения ";
        String p1_r2_n3 =  "T=1/v связь между периодом и частотой обращения ";
        String p1_r2_n4 =  "v=s/t линейная скорость ";
        String p1_r2_n5 =  "v=2pir/T линейная скорость, выраженная через период обращения ";
        String p1_r2_n6 =  "v=2pirv линейная скорость, выраженная через частоту обращения ";
        String p1_r2_n7 =  "w=ф/t omega угловая скорость ";
        String p1_r2_n8 =  "w=phi/t угловая скорость, выраженная через период обращения ";
        String p1_r2_n9 =  "w=2pi/T угловая скорость, выраженная через частоту обращения ";
        String p1_r2_n10 = "v=wr формула связи между линейной и угловой скоростью ";
        String p1_r2_n11 = "a=v^2/r центростремительное ускорение, выраженное через линейную скорость ";
        String p1_r2_n12 = "a=w^2r центростремительное ускорение, выраженное через угловую скорость ";

        String p1_r3_n1 =  "a=F/m второй закон Ньютона ";
        String p1_r3_n2 =  "F1=-F2 третий закон Ньютона ";
        String p1_r3_n3 =  "Fтр=uN модуль силы трения ";
        String p1_r3_n4 =  "Fупр x=-kx проекция силы упругости ";
        String p1_r3_n5 =  "F=mg сила тяжести ";
        String p1_r3_n6 =  "P=mg вес тела на неподвижной или равномерно движущейся опоре (подвесе) ";
        String p1_r3_n7 =  "P=m(g-a) вес тела на опоре(подвесе), движущейся с ускорением ";
        String p1_r3_n8 =  "F=Gm1m2/r^2 закон всемирного тяготения ";
        String p1_r3_n9 =  "g=GM/(R+h)^2 ускорение свободного падения ";
        String p1_r3_n10 = "v=GM/R 1-ая космическая скорость ";
        String p1_r3_n11 = "Ft=mv-mv0 второй закон Ньютона в импульсной форме ";
        String p1_r3_n12 = "m1v1+m2v2=m1v1'+m2v2' закон сохранения импульса для двух тел ";

        String p1_r4_n1 = "M=Fd момент силы относительно оси вращщения ";
        String p1_r4_n2 = "Fi=0 условие равновесия тела, не имеющего оси вращения ";
        String p1_r4_n3 = "Mi=0 условие равновесия тела, имеющего ось вращения ";

        String p1_r5_n1 = "p=m/v плотность вещества ";
        String p1_r5_n2 = "p=F/S давление ";
        String p1_r5_n3 = "p=pgh зависимость давления жидкости от высоты её столба ";
        String p1_r5_n4 = "Fдно=pgHSдно сила давления жидкости на дно сосуда ";
        String p1_r5_n5 = "Fбок=1/2pgHSбок сила давления жидкости на боковую поверхность сосуда ";
        String p1_r5_n6 = "h1/h2=p2/p1 закон сообщающихся сосудов для разнородных жидкостей ";
        String p1_r5_n7 = "Fа=pgV закон Архимеда ";
        String p1_r5_n8 = "F2=F1S2/S1 формула связи модулей сил, действующих на поршни гидравлической машины ";

        String p1_r6_n1 = "A=Fscosa работа постоянной силы ";
        String p1_r6_n2 = "A=-Fтрs работа силы трения ";
        String p1_r6_n3 = "A=mg(h1-h2) работа силы тяжести ";
        String p1_r6_n4 = "A=k/2(x1^2-x2^2) работа силы упругости ";
        String p1_r6_n5 = "N=Fv мощность при равномерном движении ";
        String p1_r6_n6 = "N=A/t мощность ";
        String p1_r6_n7 = "Eк=mv^2/2 кинетическая энергия тела ";
        String p1_r6_n8 = "Eр=mgh потенциальная энергия тела ";
        String p1_r6_n9 = "Eр=kx^2/2 потенциальная энергия упруго деформированного тела ";
        String p1_r6_n10 = "E=Eк+Eр=const полная механическая энергия замкнутой системы тел ";
        String p1_r6_n11 = "A=mv2^2/2-mv1^2/2 теорема о кинетической энергии тела ";
        String p1_r6_n12 = "n=An/A n=Nn/N коэффициент полезного действия ";

        String p1_r7_n1 = "x=Asin(wt+ф0) зависимость координаты колеблющегося тела от времени ";
        String p1_r7_n2 = "vx=vmcos(wt+ф0) v=vcos(wt+ф0) зависимость проекции скорости колеблющегося тела от времени ";
        String p1_r7_n3 = "ax=-amsin(wt+ф0) a=-asin(wt+ф0) зависимость проекции ускорения колеблющегося тела от времени ";
        String p1_r7_n4 = "w=2piv=2pi/T циклическая частота ";
        String p1_r7_n5 = "T=1/v v=1/T связь между периодом и частотой колебаний ";
        String p1_r7_n6 = "vm=wA v=wA максимальная скорость колеблющегося тела ";
        String p1_r7_n7 = "am=aw^2A a=aw^2A максимальное ускорение колеблющегося тела ";
        String p1_r7_n8 = "T=2pim/k период колебаний пружинного маятника ";
        String p1_r7_n9 = "T=2pilg период колебаний математического маятника ";
        String p1_r7_n10 = "kA^2/2=mvx^2/2+kx^2/2=mvm^2/2 kA^2/2=mv^2/2+kx^2/2=mv^2/2 полная энергия колеблющегося на пружине тела ";
        String p1_r7_n11 = "a=vT длина волны ";

        String p2_r1_n1 = "v=N/Na=m/M количество вещества ";
        String p2_r1_n2 = "M=m0Na молярная физика ";
        String p2_r1_n3 = "p=1/3nm0v^-2 основная уравнение МКТ идеального газа, записанное через средний квадрат скорости движений молекул ";
        String p2_r1_n4 = "p=2/3nE основное уравнение МКТ идеального газа, записанное через среднюю кинетическую энергюю поступательного движения молекул ";
        String p2_r1_n5 = "p=nkT завимость давления газа от концетрации его молекул и температуры ";
        String p2_r1_n6 = "E=2/3kT зависимость средней кинетической энергии поступательного движения молекул ";
        String p2_r1_n7 = "v=3RT/M зависимость средней квадратичной скорости движения молекул от температуры ";
        String p2_r1_n8 = "pV/T=const уравнение Клайперона ";
        String p2_r1_n9 = "pV=m/MRT уравнение Менделеева-Клайперона ";
        String p2_r1_n10 = "pV=const при T=const закон Бойля-Мариотта ";
        String p2_r1_n11 = "V/T=const при p=const закон Гей-Люссака ";
        String p2_r1_n12 = "p/T=const при V=const закон Шарля ";

        String p3_r1_n1 = "U=im/2MRT внутренняя энергия иделального газа ";
        String p3_r1_n2 = "Q=cm(t2-t1) количество теплоты, поглощаемое или выделяемое телом при изменении его температуры ";
        String p3_r1_n3 = "C=cm теплоёмкость тела ";
        String p3_r1_n4 = "Qп=rm количество теплоты, необходимое для превращения жидкости, взятой при температуре кипения, в пар ";
        String p3_r1_n5 = "Qпл=am количество теплоты, необходимое для плавления кристалического вещества, взятого при температуре плавления ";
        String p3_r1_n6 = "Qсг=-qm количество теплоты, выделяемое при полном сгорании данной массы топлива ";
        String p3_r1_n7 = "A'=pdeltaV работа, совершённая газом ";
        String p3_r1_n8 = "Q=deltaU+A' уравнение первого начала термодинамики ";
        String p3_r1_n9 = "Qi=0 уравнение теплового баланса ";
        String p3_r1_n10 = "n=A'/Q1=Q1-Q2/Q1 КПД теплового двигателя ";
        String p3_r1_n11 = "n=T1-T2/T1 КПД идеальной тепловой машины ";

        String p4_r1_n1  = "F=k|q1||q2|/er^2 k=1/4pie0=9*10^9I'*i'/Eё^2 закон Кулона ";
        String p4_r1_n2  = "E=F/q напряжённость электростатического поля ";
        String p4_r1_n3  = "E=k|q|/er^2 модуль нарпяжённости электростатического поля точечного заряда ";
        String p4_r1_n4  = "E=k|qш|/e(R+r)^2 модуль напряжённости электростатического поля, заряженного шара ";
        String p4_r1_n5  = "E=Ei принцип суперпозиции электрических полей ";
        String p4_r1_n6  = "ф=Wp/q потенциал электростатического поля ";
        String p4_r1_n7  = "ф=kq/er потенциал электростатического поля точечного заряда ";
        String p4_r1_n8  = "ф=Ed потенциал электростатического поля заряженного шара ";
        String p4_r1_n9  = "ф=Ed потенциал однородного электростатического поля ";
        String p4_r1_n10 = "ф=фi потенциал электростатического поля системы зарядов ";
        String p4_r1_n11 = "A=q(ф1-ф2)=qU работа по перемещению зарядов в электрическом поле ";
        String p4_r1_n12 = "E=U/d связь между модулем напряжённости и напряжением для однородного электростатического поля ";
        String p4_r1_n13 = "W=kq1q2/r потенциальная энергия взаимодействия двух электрических зарядов ";
        String p4_r1_n14 = "C=q/U электроёмкость конденсатора ";
        String p4_r1_n15 = "C=ee0S/d электроёмкость плоского конденсатора ";
        String p4_r1_n16 = "C=Ci электромкость параллельно соединенных конденсаторов ";
        String p4_r1_n17 = "1/C=1/Ci величина, обратная электроёмкости последовательно соединённых конденсаторов ";
        String p4_r1_n18 = "W=qU/2=CU^2/2=q^2/2C энергия электрического поля конденсатора ";
        String p4_r1_n19 = "o=q/S поверхность плотность заряда ";

        String p4_r2_n1  = "I=q/t сила электрического тока ";
        String p4_r2_n2  = "I=q0nvS зависимость силы тока от заряда, концентрации, скорости и площади поперечного ";
        String p4_r2_n3  = "j=I/S модуль плотности электрического тока ";
        String p4_r2_n4  = "I=U/R закон Ома для участка цепи ";
        String p4_r2_n5  = "R=p/S зависимость сопротивления от рода вещества, длины и поперечного сечения проводника ";
        String p4_r2_n6  = "R=R0(1+at) зависимость сопротивления проводника от температуры ";
        String p4_r2_n7  = "R=Ri сопротивление последовательно соединённых резисторов ";
        String p4_r2_n8  = "1/R=1/Ri величина, обратная сопротивлению параллельно соединённых резисторов ";
        String p4_r2_n9  = "A=IUt=I^2R=U^2/R работа электрического тока ";
        String p4_r2_n10 = "P=A/t=IU=I^2R=U^2/R ";
        String p4_r2_n11 = "Q=I^2Rt мощность электрического тока ";
        String p4_r2_n12 = "E=Acm/q электродвижующая сила источника тока (ЭДС) ";
        String p4_r2_n13 = "I=E/R+r закон Ома для полной цепи ";
        String p4_r2_n14 = "I=nE/R+nr сила тока в полной цепи с n  последоваельно соединёнными одинаковыми ЭДС ";
        String p4_r2_n15 = "I=E/r+r/n сила тока в неразветвлённой части полной цепи с n параллельно соединёнными одинаковыми элементами ЭДС ";
        String p4_r2_n16 = "m=kIt закон Фарадея для электролиза ";

        String p4_r3_n1 = "A=Mmax/IS=Fmax/Ideltal модуль вектора магинтной индукции ";
        String p4_r3_n2 = "F=IBdeltalsina закон Ампера ";
        String p4_r3_n3 = "F=|q|vBsina модуль силы Лоренца ";
        String p4_r3_n4 = "mv=qBR импульс заряженной частицы, движущейся по окружности в магнитном поле ";
        String p4_r3_n5 = "Ф=BScosa магнитный поток ";

        String p4_r4_n1 = "Ei=-deltaФ/deltat закон электромагнитной индукции ";
        String p4_r4_n2 = "Ф=LI магнитный поток через поверхность, ограниченную контуром ";
        String p4_r4_n3 = "Em=wФm максимальное значение ЭДС, возникающее в рамке, равномерно вращающейся в магнитном поле ";
        String p4_r4_n4 = "Eis=-deltaФ/deltat=-LdeltaI/deltat ";
        String p4_r4_n5 = "E=Bvlsina ЭДС самоиндукции ";
        String p4_r4_n6 = "q=deltaФ/R электрический заряд, протекающий по замкнутому контуру, при измении магнитного потока пронизывающего контур ";

        String p4_r5_n1  = "q=qmsin(wt+ф0) зависимость заряда на обкладках конденсатора в колебательном контуре от времени ";
        String p4_r5_n2  = "u=Umsin(wt+ф0) зависимость напряжения на обкладках конденсатора в колебательном контуре от времени ";
        String p4_r5_n3  = "i=Imcos(wt+ф0) зависимость силы тока в колебательном контуре от времени ";
        String p4_r5_n4  = "Im=wqm максимальное значение силы тока при электромагнитных колебаниях ";
        String p4_r5_n5  = "T=2piLC период собственных колебаний колебательного контура (формула Томсона) ";
        String p4_r5_n6  = "Wм=Li^2/2 энергия магнитного поля ";
        String p4_r5_n7  = "qm^2/2C=q^2/2C+Li^2/2=LI^2/2 полная энергия электромагнитного поля в колебательном контуре ";
        String p4_r5_n8  = "Iд=Im/2 дейсвующее значение силы переменного электрического тока ";
        String p4_r5_n9  = "Uд=Um/2 дейсвующее значение силы переменного напряжения ";
        String p4_r5_n10 = "XL=wL индуктивное сопротивление ";
        String p4_r5_n11 = "XC=1/wC ёмкостное сопротивление ";
        String p4_r5_n12 = "Z=R^2+(XL-XC)^2 полное сопротивление цепи переменного тока ";
        String p4_r5_n13 = "I=U/Z закон Ома для участка цепи переменного тока ";

        String p5_r1_n1 = "sina/sinb=n2/n1=v1/v2 закон преломления света ";
        String p5_r1_n2 = "n=c/v абсолютный показатель преломления ";
        String p5_r1_n3 = "+-1/F=+-1/f+-1/d формула тонкой линзы ";
        String p5_r1_n4 = "D=1/F оптическая сила линзы ";
        String p5_r1_n5 = "Г=H/h=f/d линейное увеличение линзы ";
        String p5_r1_n6 = "delta=(2k+1)a/2 условие интерференционного минимума ";
        String p5_r1_n7 = "delta=ka условие интерференционного максимума ";
        String p5_r1_n8 = "dsinф=ka условие максимумов дифракционной решётки ";

        String p6_r1_n1 = "v=v1+v2/1+v1v2/c^2 релятивистский закон сложения скоростей ";
        String p6_r1_n2 = "l=l01-v^2/c^2 длина стрержня в инерциальной системе, относительно которой он движется со скоростью v ";
        String p6_r1_n3 = "t=t0/1-v^2/c^2 интервал времени между двумя событиями в точке, которая движется относительно инерцианльной системы со скоростью v ";
        String p6_r1_n4 = "m=m0/1-v^2/c^2 зависимость массы тела от его скорости ";
        String p6_r1_n5 = "E=mc^2 связь между массой и энергией ";

        String p7_r1_n1 = "E=hv энергия фотона ";
        String p7_r1_n2 = "p=mc=hv/c импульс фотона ";
        String p7_r1_n3 = "hv=A+mv^2/2 уравнение Энштейна для фотоэффекта ";
        String p7_r1_n4 = "A=hvmin=hc/aкр работа выхода ";
        String p7_r1_n5 = "mv^2/2=eU3 условие прекращения фотоэффекта ";
        String p7_r1_n6 = "hv=Eп-Eт 2-ой постулат де-Бройля ";
        String p7_r1_n7 = "a=h/mv длина волны де-Бройля ";
        String p7_r1_n8 = "N=N02^-1/T закон радиоактивного распада ";
        String p7_r1_n9 = "deltaM=Zmр+Nmп+Mя дефект масс ";
        String p7_r1_n10 = "Eсв=deltaMc^2 энергия связи атомных ядер ";


        String p1_r1 = "Механика Кинематика прямолинейного движения" +
                p1_r1_n1 +
                p1_r1_n2 +
                p1_r1_n3 +
                p1_r1_n4 +
                p1_r1_n5 +
                p1_r1_n6 +
                p1_r1_n7 +
                p1_r1_n8 +
                p1_r1_n9 +
                p1_r1_n10;



        String p1_r2 = "Механика Кинематика криволинейного движения" +
                p1_r2_n1 +
                p1_r2_n2 +
                p1_r2_n3 +
                p1_r2_n4 +
                p1_r2_n5 +
                p1_r2_n6 +
                p1_r2_n7 +
                p1_r2_n8 +
                p1_r2_n9 +
                p1_r2_n10 +
                p1_r2_n11 +
                p1_r2_n12;

        String p1_r3 = "Механика Динамика" +
                p1_r3_n1 +
                p1_r3_n2 +
                p1_r3_n3 +
                p1_r3_n4 +
                p1_r3_n5 +
                p1_r3_n6 +
                p1_r3_n7 +
                p1_r3_n8 +
                p1_r3_n9 +
                p1_r3_n10 +
                p1_r3_n11 +
                p1_r3_n12;

        String p1_r4 = "Механика Статика" +
                p1_r4_n1 +
                p1_r4_n2 +
                p1_r4_n3;

        String p1_r5 = "Механика Гидростатика" +
                p1_r5_n1 +
                p1_r5_n2 +
                p1_r5_n3 +
                p1_r5_n4 +
                p1_r5_n5 +
                p1_r5_n6 +
                p1_r5_n7 +
                p1_r5_n8;

        String p1_r6 = "Механика Работа, энергия, мощность"+
                p1_r6_n1 +
                p1_r6_n2 +
                p1_r6_n3 +
                p1_r6_n4 +
                p1_r6_n5 +
                p1_r6_n6 +
                p1_r6_n7 +
                p1_r6_n8 +
                p1_r6_n9 +
                p1_r6_n10 +
                p1_r6_n11 +
                p1_r6_n12;

        String p1_r7 = "Механика Колебания волны"+
                p1_r7_n1 +
                p1_r7_n2 +
                p1_r7_n3 +
                p1_r7_n4 +
                p1_r7_n5 +
                p1_r7_n6 +
                p1_r7_n7 +
                p1_r7_n8 +
                p1_r7_n9 +
                p1_r7_n10 +
                p1_r7_n11;

        String p2_r1 = "Молекулярная физика" +
                p2_r1_n1 +
                p2_r1_n2 +
                p2_r1_n3 +
                p2_r1_n4 +
                p2_r1_n5 +
                p2_r1_n6 +
                p2_r1_n7 +
                p2_r1_n8 +
                p2_r1_n9 +
                p2_r1_n10 +
                p2_r1_n11 +
                p2_r1_n12;

        String p3_r1 = "Термодинамика" +
                p3_r1_n1 +
                p3_r1_n2 +
                p3_r1_n3 +
                p3_r1_n4 +
                p3_r1_n5 +
                p3_r1_n6 +
                p3_r1_n7 +
                p3_r1_n8 +
                p3_r1_n9 +
                p3_r1_n10 +
                p3_r1_n11;

        String p4_r1 = "Электродинамика Электростатика" +
                p4_r1_n1 +
                p4_r1_n2 +
                p4_r1_n3 +
                p4_r1_n4 +
                p4_r1_n5 +
                p4_r1_n6 +
                p4_r1_n7 +
                p4_r1_n8 +
                p4_r1_n9 +
                p4_r1_n10 +
                p4_r1_n11 +
                p4_r1_n12 +
                p4_r1_n13 +
                p4_r1_n14 +
                p4_r1_n15 +
                p4_r1_n16 +
                p4_r1_n17 +
                p4_r1_n18 +
                p4_r1_n19;

        String p4_r2 = "Электродинамика Постоянный электрический ток" +
                p4_r2_n1 +
                p4_r2_n2 +
                p4_r2_n3 +
                p4_r2_n4 +
                p4_r2_n5 +
                p4_r2_n6 +
                p4_r2_n7 +
                p4_r2_n8 +
                p4_r2_n9 +
                p4_r2_n10 +
                p4_r2_n11 +
                p4_r2_n12 +
                p4_r2_n13 +
                p4_r2_n14 +
                p4_r2_n15 +
                p4_r2_n16;

        String p4_r3 = "Электродинамика Магнитное поле электрического тока"+
                p4_r3_n1 +
                p4_r3_n2 +
                p4_r3_n3 +
                p4_r3_n4 +
                p4_r3_n5;

        String p4_r4 = "Электродинамика Электромагнитная индукция" +
                p4_r4_n1 +
                p4_r4_n2 +
                p4_r4_n3 +
                p4_r4_n4 +
                p4_r4_n5 +
                p4_r4_n6;

        String p4_r5 = "Электродинамика Электромагнитные колебания" +
                p4_r5_n1 +
                p4_r5_n2 +
                p4_r5_n3 +
                p4_r5_n4 +
                p4_r5_n5 +
                p4_r5_n6 +
                p4_r5_n7 +
                p4_r5_n8 +
                p4_r5_n9 +
                p4_r5_n10 +
                p4_r5_n11 +
                p4_r5_n12 +
                p4_r5_n13;

        String p5_r1 = "Оптика" +
                p5_r1_n1 +
                p5_r1_n2 +
                p5_r1_n3 +
                p5_r1_n4 +
                p5_r1_n5 +
                p5_r1_n6 +
                p5_r1_n7 +
                p5_r1_n8;

        String p6_r1 = "Элементы теории относительности" +
                p6_r1_n1 +
                p6_r1_n2 +
                p6_r1_n3 +
                p6_r1_n4 +
                p6_r1_n5;

        String p7_r1 = "Квантовая физика, атомная и ядерная физика" +
                p7_r1_n1 +
                p7_r1_n2 +
                p7_r1_n3 +
                p7_r1_n4 +
                p7_r1_n5 +
                p7_r1_n6 +
                p7_r1_n7 +
                p7_r1_n8 +
                p7_r1_n9 +
                p7_r1_n10;

        mTitleTheme.add(new formulasItem("","Механика", 0, "", p1_r1 + p1_r2 + p1_r3 + p1_r4 + p1_r5 + p1_r6 + p1_r7 + " Кинематика криволинейного движения Динамика Статика Гидростатика Работа, энергия, мощность Колебания волны"));
        mTitleTheme.add(new formulasItem("Кинематика прямолинейного движения","", 0, "", p1_r1 + "Механика Кинематика прямолинейного движения"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r1_n1, "— проекция перемещения на ось X", p1_r1_n1 + " Механика Кинематика прямолинейного движения"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r1_n2, "— скорость равномерного прямолинейного движения", p1_r1_n2 + " Механика Кинематика прямолинейного движения"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r1_n3, "— средняя скорость", p1_r1_n3 + "Механика Кинематика прямолинейного движения"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r1_n4, "— уравнение равномерного прямолинейного движения", p1_r1_n4 + "Механика Кинематика прямолинейного движения"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r1_n5, "— ускорение при равноускоренном движении", p1_r1_n5 + "Механика Кинематика прямолинейного движения"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r1_n6, "— скорость при равноускоренном движении", p1_r1_n6 + "Механика Кинематика прямолинейного движения"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r1_n7, "— перемещение при равноускоренном движении", p1_r1_n7 + "Механика Кинематика прямолинейного движения"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r1_n8, "— зависимость перемещения при равноускоренном движении от времени", p1_r1_n8 + "Механика Кинематика прямолинейного движения"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r1_n9, "— проекция перемещения при равноускоренном движении без времени", p1_r1_n9 + "Механика Кинематика прямолинейного движения"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r1_n10, "— уравнение раввноускоренного движения", p1_r1_n10 + "Механика Кинематика прямолинейного движения"));

        mTitleTheme.add(new formulasItem("Кинематика криволинейного движения","", 0, "", p1_r2 + "Механика Кинематика криволинейного движения"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r2_n1, "— частота обращения", p1_r2_n1 + "Механика Кинематика криволинейного движения"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r2_n2, "— период обращения", p1_r2_n2 + "Механика Кинематика криволинейного движения"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r2_n3, "— связь между периодом и частотой обращения", p1_r2_n3 + "Механика Кинематика криволинейного движения"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r2_n4, "— линейная скорость", p1_r2_n4 + "Механика Кинематика криволинейного движения"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r2_n5, "— линейная скорость, выраженная через период обращения", p1_r2_n5 + "Механика Кинематика криволинейного движения"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r2_n6, "— линейная скорость, выраженная через частоту обращения", p1_r2_n6 + "Механика Кинематика криволинейного движения"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r2_n7, "— угловая скорость", p1_r2_n7 + "Механика Кинематика криволинейного движения"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r2_n8, "— угловая скорость, выраженная через период обращения", p1_r2_n8 + "Механика Кинематика криволинейного движения"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r2_n9, "— угловая скорость, выраженная через частоту обращения", p1_r2_n9 + "Механика Кинематика криволинейного движения"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r2_n10, "— формула связи между линейной и угловой скоростью", p1_r2_n10 + "Механика Кинематика криволинейного движения"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r2_n11, "— центростремительное ускорение, выраженное через линейную скорость", p1_r2_n11 + "Механика Кинематика криволинейного движения"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r2_n12, "— центростремительное ускорение, выраженное через угловую скорость", p1_r2_n12 + "Механика Кинематика криволинейного движения"));

        mTitleTheme.add(new formulasItem("Динамика","", 0, "", p1_r3 + "Механика Динамика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r3_n1, "— второй закон Ньютона", p1_r3_n1 + "Механика Динамика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r3_n2, "— третий закон Ньютона", p1_r3_n2 + "Механика Динамика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r3_n3, "— модуль силы трения", p1_r3_n3 + "Механика Динамика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r3_n4, "— проекция силы упругости", p1_r3_n4 + "Механика Динамика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r3_n5, "— сила тяжести", p1_r3_n5 + "Механика Динамика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r3_n6, "— вес тела на неподвижной или равномерно движущейся опоре (подвесе)", p1_r3_n6 + "Механика Динамика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r3_n7, "— вес тела на опоре(подвесе), движущейся с ускорением", p1_r3_n7 + "Механика Динамика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r3_n8, "— закон всемирного тяготения", p1_r3_n8 + "Механика Динамика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r3_n9, "— ускорение свободного падения", p1_r3_n9 + "Механика Динамика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r3_n10, "— 1-ая космическая скорость", p1_r3_n10 + "Механика Динамика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r3_n11, "— второй закон Ньютона в импульсной форме", p1_r3_n11 + "Механика Динамика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r3_n12, "— закон сохранения импульса для двух тел", p1_r3_n12 + "Механика Динамика"));

        mTitleTheme.add(new formulasItem("Статика","", 0, "", p1_r4 + "Механика Статика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r4_n1, "— момент силы относительно оси вращщения", p1_r4_n1 + "Механика Статика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r4_n2, "— условие равновесия тела, не имеющего оси вращения", p1_r4_n2 + "Механика Статика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r4_n3, "— условие равновесия тела, имеющего ось вращения", p1_r4_n3 + "Механика Статика"));

        mTitleTheme.add(new formulasItem("Гидростатика","", 0, "", p1_r5 + "Механика Гидростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r5_n1, "— плотность вещества", p1_r5_n1 + "Механика Гидростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r5_n2, "— давление", p1_r5_n2 + "Механика Гидростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r5_n3, "— зависимость давления жидкости от высоты её столба", p1_r5_n3 + "Механика Гидростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r5_n4, "— сила давления жидкости на дно сосуда", p1_r5_n4 + "Механика Гидростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r5_n5, "— сила давления жидкости на боковую поверхность сосуда", p1_r5_n5 + "Механика Гидростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r5_n6, "— закон сообщающихся сосудов для разнородных жидкостей", p1_r5_n6 + "Механика Гидростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r5_n7, "— закон Архимеда", p1_r5_n7 + "Механика Гидростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r5_n8, "— формула связи модулей сил, действующих на поршни гидравлической машины", p1_r5_n8 + "Механика Гидростатика"));

        mTitleTheme.add(new formulasItem("Работа, энергия, мощность","", 0, "", p1_r6 + "Механика Работа, энергия, мощность"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r6_n1, "— работа постоянной силы", p1_r6_n1 + "Механика Работа, энергия, мощность"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r6_n2, "— работа силы трения", p1_r6_n2 + "Механика Работа, энергия, мощность"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r6_n3, "— работа силы тяжести", p1_r6_n3 + "Механика Работа, энергия, мощность"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r6_n4, "— работа силы упругости", p1_r6_n4 + "Механика Работа, энергия, мощность"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r6_n5, "— мощность при равномерном движении", p1_r6_n5 + "Механика Работа, энергия, мощность"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r6_n6, "— мощность", p1_r6_n6 + "Механика Работа, энергия, мощность"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r6_n7, "— кинетическая энергия тела", p1_r6_n7 + "Механика Работа, энергия, мощность"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r6_n8, "— потенциальная энергия тела", p1_r6_n8 + "Механика Работа, энергия, мощность"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r6_n9, "— потенциальная энергия упруго деформированного тела", p1_r6_n9 + "Механика Работа, энергия, мощность"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r6_n10, "— полная механическая энергия замкнутой системы тел", p1_r6_n10 + "Механика Работа, энергия, мощность"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r6_n11, "— теорема о кинетической энергии тела", p1_r6_n11 + "Механика Работа, энергия, мощность"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r6_n12, "— коэффициент полезного действия", p1_r6_n12 + "Механика Работа, энергия, мощность"));

        mTitleTheme.add(new formulasItem("Колебания волны", "",0, "", p1_r7 + "Механика Колебания волны"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r7_n1, "— зависимость координаты колеблющегося тела от времени", p1_r7_n1 + "Механика Колебания волны"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r7_n2, "— зависимость проекции скорости колеблющегося тела от времени", p1_r7_n2 + "Механика Колебания волны"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r7_n3, "— зависимость проекции ускорения колеблющегося тела от времени", p1_r7_n3 + "Механика Колебания волны"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r7_n4, "— циклическая частота", p1_r7_n4 + "Механика Колебания волны"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r7_n5, "— связь между периодом и частотой колебаний", p1_r7_n5 + "Механика Колебания волны"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r7_n6, "— максимальная скорость колеблющегося тела", p1_r7_n6 + "Механика Колебания волны"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r7_n7, "— максимальное ускорение колеблющегося тела", p1_r7_n7 + "Механика Колебания волны"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r7_n8, "— период колебаний пружинного маятника", p1_r7_n8 + "Механика Колебания волны"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r7_n9, "— период колебаний математического маятника", p1_r7_n9 + "Механика Колебания волны"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r7_n10, "— полная энергия колеблющегося на пружине тела", p1_r7_n10 + "Механика Колебания волны"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p1_r7_n11, "— длина волны", p1_r7_n11 + "Механика Колебания волны"));

        mTitleTheme.add(new formulasItem("","Молекулярная физика", 0, "", p2_r1 + "Молекулярная физика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p2_r1_n1, "— количество вещества", p2_r1_n1 + "Молекулярная физика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p2_r1_n2, "— молярная физика", p2_r1_n2 + "Молекулярная физика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p2_r1_n3, "— основная уравнение МКТ идеального газа, записанное через средний квадрат скорости движений молекул", p2_r1_n3 + "Молекулярная физика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p2_r1_n4, "— основное уравнение МКТ идеального газа, записанное через среднюю кинетическую энергюю поступательного движения молекул", p2_r1_n4 + "Молекулярная физика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p2_r1_n5, "— завимость давления газа от концетрации его молекул и температуры", p2_r1_n5 + "Молекулярная физика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p2_r1_n6, "— зависимость средней кинетической энергии поступательного движения молекул", p2_r1_n6 + "Молекулярная физика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p2_r1_n7, "— зависимость средней квадратичной скорости движения молекул от температуры", p2_r1_n7 + "Молекулярная физика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p2_r1_n8, "— уравнение Клайперона", p2_r1_n8 + "Молекулярная физика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p2_r1_n9, "— уравнение Менделеева-Клайперона", p2_r1_n9 + "Молекулярная физика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p2_r1_n10, "— закон Бойля-Мариотта", p2_r1_n10 + "Молекулярная физика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p2_r1_n11, "— закон Гей-Люссака", p2_r1_n11 + "Молекулярная физика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p2_r1_n12, "— закон Шарля", p2_r1_n12 + "Молекулярная физика"));

        mTitleTheme.add(new formulasItem("","Термодинамика", 0, "", p3_r1 + "Термодинамика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p3_r1_n1, "— внутренняя энергия иделального газа", p3_r1_n1 + "Термодинамика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p3_r1_n2, "— количество теплоты, поглощаемое или выделяемое телом при изменении его температуры", p3_r1_n2 + "Термодинамика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p3_r1_n3, "— теплоёмкость тела", p3_r1_n3 + "Термодинамика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p3_r1_n4, "— количество теплоты, необходимое для превращения жидкости, взятой при температуре кипения, в пар", p3_r1_n4 + "Термодинамика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p3_r1_n5, "— количество теплоты, необходимое для плавления кристалического вещества, взятого при температуре плавления", p3_r1_n5 + "Термодинамика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p3_r1_n6, "— количество теплоты, выделяемое при полном сгорании данной массы топлива", p3_r1_n6 + "Термодинамика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p3_r1_n7, "— работа, совершённая газом", p3_r1_n7 + "Термодинамика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p3_r1_n8, "— уравнение первого начала термодинамики", p3_r1_n8 + "Термодинамика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p3_r1_n9, "— уравнение теплового баланса", p3_r1_n9 + "Термодинамика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p3_r1_n10, "— КПД теплового двигателя", p3_r1_n10 + "Термодинамика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p3_r1_n11, "— КПД идеальной тепловой машины", p3_r1_n11 + "Термодинамика"));

        mTitleTheme.add(new formulasItem("","Электродинамика", 0, "", p4_r1 + p4_r2 + p4_r3 + p4_r4 + p4_r5 + "Электродинамика Электростатика Постоянный электрический ток Магнитное поле электрического тока Электромагнитная индукция Электромагнитные колебания"));
        mTitleTheme.add(new formulasItem("Электростатика","", 0, "", p4_r1 + "Электродинамика Электростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r1_n1, "— закон Кулона", p4_r1_n1 + "Электродинамика Электростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r1_n2, "— напряжённость электростатического поля", p4_r1_n2 + "Электродинамика Электростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r1_n3, "— модуль нарпяжённости электростатического поля точечного заряда", p4_r1_n3 + "Электродинамика Электростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r1_n4, "— модуль напряжённости электростатического поля, заряженного шара", p4_r1_n4 + "Электродинамика Электростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r1_n5, "— принцип суперпозиции электрических полей", p4_r1_n5 + "Электродинамика Электростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r1_n6, "— потенциал электростатического поля", p4_r1_n6 + "Электродинамика Электростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r1_n7, "— потенциал электростатического поля точечного заряда", p4_r1_n7 + "Электродинамика Электростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r1_n8, "— потенциал электростатического поля заряженного шара", p4_r1_n8 + "Электродинамика Электростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r1_n9, "— потенциал однородного электростатического поля", p4_r1_n9 + "Электродинамика Электростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r1_n10, "— потенциал электростатического поля системы зарядов", p4_r1_n10 + "Электродинамика Электростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r1_n11, "— работа по перемещению зарядов в электрическом поле", p4_r1_n11 + "Электродинамика Электростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r1_n12, "— связь между модулем напряжённости и напряжением для однородного электростатического поля", p4_r1_n12 + "Электродинамика Электростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r1_n13, "— потенциальная энергия взаимодействия двух электрических зарядов", p4_r1_n13 + "Электродинамика Электростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r1_n14, "— электроёмкость конденсатора", p4_r1_n14 + "Электродинамика Электростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r1_n15, "— электроёмкость плоского конденсатора", p4_r1_n15 + "Электродинамика Электростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r1_n16, "— электромкость параллельно соединенных конденсаторов", p4_r1_n16 + "Электродинамика Электростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r1_n17, "— величина, обратная электроёмкости последовательно соединённых конденсаторов", p4_r1_n17 + "Электродинамика Электростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r1_n18, "— энергия электрического поля конденсатора", p4_r1_n18 + "Электродинамика Электростатика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r1_n19, "— поверхность плотность заряда", p4_r1_n19 + "Электродинамика Электростатика"));

        mTitleTheme.add(new formulasItem("Постоянный электрический ток","", 0, "", p4_r2 + "Электродинамика Постоянный электрический ток"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r2_n1, "— сила электрического тока", p4_r2_n1 + "Электродинамика Постоянный электрический ток"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r2_n2, "— зависимость силы тока от заряда, концентрации, скорости и площади поперечного ", p4_r2_n2 + "Электродинамика Постоянный электрический ток"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r2_n3, "— модуль плотности электрического тока", p4_r2_n3 + "Электродинамика Постоянный электрический ток"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r2_n4, "— закон Ома для участка цепи", p4_r2_n4 + "Электродинамика Постоянный электрический ток"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r2_n5, "— зависимость сопротивления от рода вещества, длины и поперечного сечения проводника", p4_r2_n5 + "Электродинамика Постоянный электрический ток"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r2_n6, "— зависимость сопротивления проводника от температуры", p4_r2_n6 + "Электродинамика Постоянный электрический ток"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r2_n7, "— сопротивление последовательно соединённых резисторов", p4_r2_n7 + "Электродинамика Постоянный электрический ток"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r2_n8, "— величина, обратная сопротивлению параллельно соединённых резисторов", p4_r2_n8 + "Электродинамика Постоянный электрический ток"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r2_n9, "— работа электрического тока", p4_r2_n9 + "Электродинамика Постоянный электрический ток"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r2_n10, "— мощность электрического тока", p4_r2_n10 + "Электродинамика Постоянный электрический ток"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r2_n11, "— закон Джоуля-Ленца", p4_r2_n11 + "Электродинамика Постоянный электрический ток"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r2_n12, "— электродвижующая сила источника тока (ЭДС)", p4_r2_n12 + "Электродинамика Постоянный электрический ток"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r2_n13, "— закон Ома для полной цепи", p4_r2_n13 + "Электродинамика Постоянный электрический ток"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r2_n14, "— сила тока в полной цепи с n  последоваельно соединёнными одинаковыми ЭДС", p4_r2_n14 + "Электродинамика Постоянный электрический ток"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r2_n15, "— сила тока в неразветвлённой части полной цепи с n параллельно соединёнными одинаковыми элементами ЭДС", p4_r2_n15 + "Электродинамика Постоянный электрический ток"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r2_n16, "— закон Фарадея для электролиза", p4_r2_n16 + "Электродинамика Постоянный электрический ток"));

        mTitleTheme.add(new formulasItem("Магнитное поле электрического тока","", 0, "", p4_r3 + "Электродинамика Магнитное поле электрического тока"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r3_n1, "— модуль вектора магинтной индукции", p4_r3_n1 + "Электродинамика Магнитное поле электрического тока"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r3_n2, "— закон Ампера", p4_r3_n2 + "Электродинамика Магнитное поле электрического тока"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r3_n3, "— модуль силы Лоренца", p4_r3_n3 + "Электродинамика Магнитное поле электрического тока"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r3_n4, "— импульс заряженной частицы, движущейся по окружности в магнитном поле", p4_r3_n4 + "Электродинамика Магнитное поле электрического тока"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r3_n5, "— магнитный поток", p4_r3_n5 + "Электродинамика Магнитное поле электрического тока"));

        mTitleTheme.add(new formulasItem("Электромагнитная индукция","", 0, "", p4_r4 + "Электродинамика Электромагнитная индукция"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r4_n1, "— закон электромагнитной индукции", p4_r4_n1 + "Электродинамика Электромагнитная индукция"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r4_n2, "— магнитный поток через поверхность, ограниченную контуром", p4_r4_n2 + "Электродинамика Электромагнитная индукция"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r4_n3, "— максимальное значение ЭДС, возникающее в рамке, равномерно вращающейся в магнитном поле", p4_r4_n3 + "Электродинамика Электромагнитная индукция"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r4_n4, "— ЭДС самоиндукции", p4_r4_n4 + "Электродинамика Электромагнитная индукция"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r4_n5, "— ЭДС индукции в движущихся проводниках", p4_r4_n5 + "Электродинамика Электромагнитная индукция"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r4_n6, "— электрический заряд, протекающий по замкнутому контуру, при измении магнитного потока пронизывающего контур", p4_r4_n6 + "Электродинамика Электромагнитная индукция"));

        mTitleTheme.add(new formulasItem("Электромагнитные колебания","", 0, "", p4_r5 + "Электродинамика Электромагнитные колебания"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r5_n1, "— зависимость заряда на обкладках конденсатора в колебательном контуре от времени", p4_r5_n1 + "Электродинамика Электромагнитные колебания"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r5_n2, "— зависимость напряжения на обкладках конденсатора в колебательном контуре от времени", p4_r5_n2 + "Электродинамика Электромагнитные колебания"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r5_n3, "— зависимость силы тока в колебательном контуре от времени", p4_r5_n3 + "Электродинамика Электромагнитные колебания"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r5_n4, "— максимальное значение силы тока при электромагнитных колебаниях", p4_r5_n4 + "Электродинамика Электромагнитные колебания"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r5_n5, "— период собственных колебаний колебательного контура (формула Томсона)", p4_r5_n5 + "Электродинамика Электромагнитные колебания"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r5_n6, "— энергия магнитного поля", p4_r5_n6 + "Электродинамика Электромагнитные колебания"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r5_n7, "— полная энергия электромагнитного поля в колебательном контуре", p4_r5_n7 + "Электродинамика Электромагнитные колебания"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r5_n8, "— дейсвующее значение силы переменного электрического тока", p4_r5_n8 + "Электродинамика Электромагнитные колебания"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r5_n9, "— дейсвующее значение силы переменного напряжения", p4_r5_n9 + "Электродинамика Электромагнитные колебания"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r5_n10, "— индуктивное сопротивление", p4_r5_n10 + "Электродинамика Электромагнитные колебания"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r5_n11, "— ёмкостное сопротивление", p4_r5_n11 + "Электродинамика Электромагнитные колебания"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r5_n12, "— полное сопротивление цепи переменного тока", p4_r5_n12 + "Электродинамика Электромагнитные колебания"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p4_r5_n13, "— закон Ома для участка цепи переменного тока", p4_r5_n13 + "Электродинамика Электромагнитные колебания"));

        mTitleTheme.add(new formulasItem("","Оптика", 0, "", p5_r1 + "Оптика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p5_r1_n1, "— закон преломления света", p5_r1_n1 + "Оптика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p5_r1_n2, "— абсолютный показатель преломления", p5_r1_n2 + "Оптика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p5_r1_n3, "— формула тонкой линзы", p5_r1_n3 + "Оптика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p5_r1_n4, "— оптическая сила линзы", p5_r1_n4 + "Оптика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p5_r1_n5, "— линейное увеличение линзы", p5_r1_n5 + "Оптика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p5_r1_n6, "— условие интерференционного минимума", p5_r1_n6 + "Оптика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p5_r1_n7, "— условие интерференционного максимума", p5_r1_n7 + "Оптика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p5_r1_n8, "— условие максимумов дифракционной решётки", p5_r1_n8 + "Оптика"));

        mTitleTheme.add(new formulasItem("","Элементы теории относительности", 0, "", p6_r1 + "Элементы теории относительности"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p6_r1_n1, "— релятивистский закон сложения скоростей", p6_r1_n1 + "Элементы теории относительности"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p6_r1_n2, "— длина стрержня в инерциальной системе, относительно которой он движется со скоростью v", p6_r1_n2 + "Элементы теории относительности"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p6_r1_n3, "— интервал времени между двумя событиями в точке, которая движется относительно инерцианльной системы со скоростью v", p6_r1_n3 + "Элементы теории относительности"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p6_r1_n4, "— зависимость массы тела от его скорости", p6_r1_n4 + "Элементы теории относительности"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p6_r1_n5, "— связь между массой и энергией", p6_r1_n5 + "Элементы теории относительности"));

        mTitleTheme.add(new formulasItem("","Квантовая физика, атомная и ядерная физика", 0, "", p7_r1 + "Квантовая физика, атомная и ядерная физика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p7_r1_n1, "— энергия фотона", p7_r1_n1 + "Квантовая физика, атомная и ядерная физика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p7_r1_n2, "— импульс фотона", p7_r1_n2 + "Квантовая физика, атомная и ядерная физика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p7_r1_n3, "— уравнение Энштейна для фотоэффекта", p7_r1_n3 + "Квантовая физика, атомная и ядерная физика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p7_r1_n4, "— работа выхода", p7_r1_n4 + "Квантовая физика, атомная и ядерная физика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p7_r1_n5, "— условие прекращения фотоэффекта", p7_r1_n5 + "Квантовая физика, атомная и ядерная физика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p7_r1_n6, "— 2-ой постулат де-Бройля", p7_r1_n6 + "Квантовая физика, атомная и ядерная физика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p7_r1_n7, "— длина волны де-Бройля", p7_r1_n7 + "Квантовая физика, атомная и ядерная физика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p7_r1_n8, "— закон радиоактивного распада", p7_r1_n8 + "Квантовая физика, атомная и ядерная физика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p7_r1_n9, "— дефект масс", p7_r1_n9 + "Квантовая физика, атомная и ядерная физика"));
        mTitleTheme.add(new formulasItem("","", R.drawable.p7_r1_n10, "— энергия связи атомных ядер", p7_r1_n10 + "Квантовая физика, атомная и ядерная физика"));

    }
}